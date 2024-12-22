package com.ecom.dto;

import lombok.*;

@Setter
@Getter
public class ApiResponse {
	private String mesg;

	public ApiResponse(String mesg) {
		super();
		this.mesg = mesg;
	}
	
	

}
