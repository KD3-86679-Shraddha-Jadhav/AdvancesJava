package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.Service.ProductService;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.ProductDelDto;
import com.ecom.dto.ProductReqDto;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> addProductDetails(@RequestBody ProductReqDto dto)
	{
		try {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(dto));
		}
		catch(RuntimeException e)
		{
			return  ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(e.getMessage()));
		}
		
	}
	
	@DeleteMapping("/{prodId}")
	public ResponseEntity<?> deleteProduct(@RequestBody ProductDelDto dto)
	{
		try {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.deleteProduct(dto));
		}
		catch(RuntimeException e)
		{
			return  ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(e.getMessage()));
		}
		
	}

}
