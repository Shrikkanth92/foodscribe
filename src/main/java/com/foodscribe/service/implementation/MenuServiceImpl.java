package com.foodscribe.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodscribe.domain.MenuItem;
import com.foodscribe.domain.Restaurant;
import com.foodscribe.repository.MenuRepository;
import com.foodscribe.repository.RestaurantRepository;
import com.foodscribe.service.MenuService;
import com.foodscribe.service.RestaurantService;

@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	private MenuRepository menuRepository;
	

	@Override
	public List<MenuItem> findByRestaurantId(Long id) {
		return menuRepository.findByRestaurantIdOrderByItemCategory(id);
	}
	
}


