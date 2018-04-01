package com.foodscribe.service;

import java.util.List;

import com.foodscribe.domain.MenuItem;

public interface MenuService {
	
	List<MenuItem> findByRestaurantId(Long id);

}
