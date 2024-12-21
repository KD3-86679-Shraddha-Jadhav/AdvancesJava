package com.blogs.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {

	private String messgage;
	private LocalDateTime timeStamp;
	public ApiResponse(String messgage) {
		super();
		this.messgage = messgage;
		this.timeStamp = LocalDateTime.now();
	}
	
}
