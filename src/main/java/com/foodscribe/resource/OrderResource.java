package com.foodscribe.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodscribe.domain.Order;
import com.foodscribe.domain.User;
import com.foodscribe.service.UserService;


@RestController
@RequestMapping("/order")
public class OrderResource {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/orderList")
	public List<Order> getOrderList(@RequestHeader(value="userid") Long userid) {
		User user = userService.findById(userid);
		List<Order> orderList = user.getOrderList();
		
		return orderList;
	}

}
