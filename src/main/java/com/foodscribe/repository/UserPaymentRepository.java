package com.foodscribe.repository;

import org.springframework.data.repository.CrudRepository;

import com.foodscribe.domain.UserPayment;


public interface UserPaymentRepository extends CrudRepository<UserPayment, Long>{

}
