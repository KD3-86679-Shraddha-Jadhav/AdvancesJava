package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.Service.OrdersService;
import com.ecom.Service.ProductService;
import com.ecom.Service.UserService;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.PlaceOrderDto;
import com.ecom.dto.ProductRespDto;
import com.ecom.dto.UserReqDto;
import com.ecom.dto.UserRespDto;
import com.ecom.entitties.ProductsEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private ProductService productService;
	
	@Autowired
	private OrdersService orderService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody @Valid UserReqDto dto)
	{
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.signUpuser(dto));
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/products")
	public ResponseEntity<?>getAllProductDetails()
	{
		
			List<ProductsEntity>products=productService.getAllproducdetails();
			if(products.isEmpty())
			{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
		return ResponseEntity.ok(products);
			
		
	}
	
	@PostMapping("/placeorder")
	public ResponseEntity<?>placeOrder(@RequestBody PlaceOrderDto dto)
	{
		
		try {
			System.out.println("in placeorder...");
			return ResponseEntity.status(HttpStatus.CREATED).body(orderService.PlaceOrder(dto));
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	
		
	}
	

	
	
	
	
	

}
