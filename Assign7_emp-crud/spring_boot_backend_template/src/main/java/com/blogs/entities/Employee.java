package com.blogs.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Employee extends BaseEntity{

	@Column(length=20,name ="first_name")
	private String firstName;
	
	@Column(length=20,name="last_name")
	private String lastName;
	
	@Column(length=20,name="email")
	private String email;
	private String password;
	
	@Column(length=20,name="department_name")
	private String department;
	
	private String location;
	private Double salary;
	private LocalDate dob;
	
	public Employee(String firstName, String lastName, String email, String password, String department,
			String location, Double salary, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.department = department;
		this.location = location;
		this.salary = salary;
		this.dob = dob;
	}
	
	
}
