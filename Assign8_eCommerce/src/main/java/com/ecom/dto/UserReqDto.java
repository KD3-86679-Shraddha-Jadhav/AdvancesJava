package com.ecom.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.ecom.entitties.UserRole;

import jakarta.persistence.EnumType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserReqDto extends BaseDto {
	
	
		@NotEmpty
		private String firstName;
		
		@NotEmpty
		private String lastName;
		
		@Length(min=5,max=30)
		@Email
		private String email;
		
		@Past
		private LocalDate dob;
		
		@Pattern(regexp =  "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message="Invalid Password!!")
		private String password;
		
		
		private String location;
		
	
		private UserRole role;


		public UserReqDto(String firstName, String lastName, String email, LocalDate dob, String password,
				String location, UserRole role) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.dob = dob;
			this.password = password;
			this.location = location;
			this.role = role;
		}


		
	
		
		
		
		
		
		

	}



