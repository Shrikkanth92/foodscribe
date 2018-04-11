package com.foodscribe.resource;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodscribe.domain.CartItem;
import com.foodscribe.domain.MenuItem;
import com.foodscribe.domain.ShoppingCart;
import com.foodscribe.domain.User;
import com.foodscribe.service.CartItemService;
import com.foodscribe.service.MenuService;
import com.foodscribe.service.ShoppingCartService;
import com.foodscribe.service.UserService;



@RestController
@RequestMapping("/cart")
public class ShoppingCartResource {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MenuService menuService;
	 
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ShoppingCartService cartService;
	
	@RequestMapping("/add")
	public ResponseEntity addItem(@RequestBody HashMap<String, String> mapper, Principal principal) {
		
		String menuItemId = mapper.get("menuItemId");
		String qty = mapper.get("qty");
		
		User user = userService.findByUsername(principal.getName());
		MenuItem menuItem = menuService.findById(Long.parseLong(menuItemId));
		
		CartItem cartItem = cartItemService.addMenuItemToCartItem(menuItem, user, Integer.parseInt(qty));
		
		return new ResponseEntity(" Menu Item added successfully!", HttpStatus.OK); 
	}
	
	@RequestMapping("/getCartItemList")
	public List<CartItem> getCartItemList(Principal principal){
		User user = userService.findByUsername(principal.getName());
		ShoppingCart cart = user.getShoppingCart();
		
		List<CartItem> cartItems = cartItemService.findByShoppingCart(cart);
		
		cartService.updateShoppingCart(cart);
		
		return cartItems;
	}
	
	@RequestMapping("/getShoppingCart")
	public ShoppingCart getShoppingCart(Principal principal){
		User user = userService.findByUsername(principal.getName());
		
		ShoppingCart cart  = user.getShoppingCart();
		
		cartService.updateShoppingCart(cart);
		
		return cart;
	}
	
	@RequestMapping("/removeItem")
	public ResponseEntity removeItem(@RequestBody String id){
		cartItemService.removeCartItem(cartItemService.findById(Long.parseLong(id)));
		
		return new ResponseEntity("Menu Item  deleted successfully!", HttpStatus.OK);
	}
	
	@RequestMapping("/updateCartItem")
	public ResponseEntity updateCartItem(@RequestBody HashMap<String, String> mapper){
		String cartItemId = mapper.get("cartItemId");
		String qty = mapper.get("qty");
		
		CartItem cartItem  = cartItemService.findById(Long.parseLong(cartItemId));
		cartItem.setQty(Integer.parseInt(qty));
		
		cartItemService.updateItem(cartItem);
		
		return new ResponseEntity("Menu Item  updated successfully!", HttpStatus.OK);
	}
}
