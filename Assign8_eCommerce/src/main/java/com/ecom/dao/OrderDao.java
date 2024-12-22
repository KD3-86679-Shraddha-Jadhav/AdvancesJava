package com.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entitties.OrdersEntity;

public interface OrderDao extends JpaRepository<OrdersEntity,Long>{
	
	

}
