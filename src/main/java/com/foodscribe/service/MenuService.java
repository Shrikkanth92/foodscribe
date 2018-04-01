package com.foodscribe.service;

import java.util.List;

import com.foodscribe.domain.Restaurant;

public interface MenuService {
	
	Menu findByRestId(String id);

}
