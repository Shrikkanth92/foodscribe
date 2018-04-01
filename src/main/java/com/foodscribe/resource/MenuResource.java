package com.foodscribe.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodscribe.domain.Menu;
import com.foodscribe.domain.Restaurant;
import com.foodscribe.service.MenuService;
import com.foodscribe.service.RestaurantService;

@RestController
@RequestMapping("/menu")
public class MenuResource {
	
	@Autowired
	private MenuService menuService;	
	
	@RequestMapping("/{restaurant_id}")
	public Menu getMenu(@PathVariable("id") String id){
		Menu menuForRest = menuService.findByRestId(id);
		return menuForRest;
	}

}


