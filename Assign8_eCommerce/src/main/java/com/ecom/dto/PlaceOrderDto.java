package com.ecom.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PlaceOrderDto {
	
	private Long customer;
	private Long product;
	private int qauntity;
	
}
