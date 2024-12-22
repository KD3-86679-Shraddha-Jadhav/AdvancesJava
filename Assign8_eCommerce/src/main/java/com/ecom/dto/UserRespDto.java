package com.ecom.dto;

import java.time.LocalDate;

import com.ecom.entitties.UserRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserRespDto {
	
	private String firstName;
	
	
	private String lastName;
	
	
	private String email;
	

	private LocalDate dob;
	
	
	private String location;
	

	private UserRole role;


}