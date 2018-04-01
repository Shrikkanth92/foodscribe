package com.foodscribe.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.foodscribe.domain.Menu;
import com.foodscribe.domain.Restaurant;

public interface MenuRepository extends CrudRepository<Menu, Long>{
	
	Menu findByRestId(String id);

}
