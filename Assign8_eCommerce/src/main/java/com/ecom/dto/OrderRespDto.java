package com.ecom.dto;

import java.util.ArrayList;
import java.util.List;

import com.ecom.entitties.ProductsEntity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class OrderRespDto extends BaseDto {
	
	
	

	private ProductsEntity product;
	
	private int qauntity;
	private double total;
	
	

}
