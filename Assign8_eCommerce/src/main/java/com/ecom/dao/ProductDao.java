package com.ecom.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entitties.ProductsEntity;


public interface ProductDao extends JpaRepository<ProductsEntity,Long> {

	

	
}
