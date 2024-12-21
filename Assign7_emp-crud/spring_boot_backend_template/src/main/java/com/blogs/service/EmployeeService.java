package com.blogs.service;

import java.util.List;

import com.blogs.dto.ApiResponse;
import com.blogs.entities.Employee;

public interface EmployeeService {
//get all employess
	List<Employee> getAllEmployess();
	
	String addNewEmployee(Employee employee);
	
	Employee getEmployeeDetails(Long empId);
	Employee updateEmployee(Employee detachedEmp);
	ApiResponse deleteEmployee(Long employeeId);
}
