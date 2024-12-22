package com.ecom.dto;

import java.time.LocalDate;

import com.ecom.entitties.BaseEntity;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductReqDto {
	
	
		
		private String title;
		
	
		private String description;
		
		
		private double price;
		
		
		private int availCount;
		private Long userId;
		
		
		private boolean isActive=true;


		

		
		
		
		

	}



