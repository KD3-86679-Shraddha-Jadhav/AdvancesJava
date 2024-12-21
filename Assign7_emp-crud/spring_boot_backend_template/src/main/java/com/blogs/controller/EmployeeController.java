package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.entities.Employee;
import com.blogs.service.EmployeeService;

import io.swagger.v3.core.model.ApiDescription;

@RestController
@RequestMapping("/employees/")
@CrossOrigin(origins ="http://localhost:3000")
public class EmployeeController {

	//depcy
	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController() {
		System.out.println("in ctor"+getClass());
	}
	

	/*
	 * URL - http://host:port/categories Method - GET payload - none ! resp - JSON
	 * representation of List<Category> Desc - get all categories
	 */
	@GetMapping
	public ResponseEntity<?> getEmployees(){
		System.out.println("get all");
		List<Employee> employee = employeeService.getAllEmployess();
		if(employee.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(employee);
	}
	
	/*
	 * URL - http://host:port/categories Method - POST payload - JSON representation
	 * of category -> Java - @RequestBody resp - String Desc - add new category
	 */
	
	@PostMapping
	public ResponseEntity<?> addNewEmployee(@RequestBody Employee employee){
		System.out.println("in add emp"+ employee);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(employeeService.addNewEmployee(employee));
	}
	
	/*
	 * URL - http://host:port/categories/{catId} Method - GET payload - URI variable
	 * - category id resp - Category -> JSON Desc - get category details
	 */
	@GetMapping("/{empId}")
	public ResponseEntity<?> getEmployeeDetails(@PathVariable Long empId){
		System.out.println("in get details "+empId);
		try {
			
			Employee employee = employeeService.getEmployeeDetails(empId);
			return ResponseEntity.ok(employee);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e. getMessage()));
		}
	}
	
	/*
	 * URL - http://host:port/categories/{categoryId} Method - PUT payload - updated
	 * category contents resp - success - api resp dto resp - error -api resp dto
	 * Desc - Update category details
	 */
	@PutMapping
	public Employee updateEmployeeDetails(@RequestBody  Employee detachedEmp){
		System.out.println("in update employee"+detachedEmp);
		return employeeService.updateEmployee(detachedEmp);
	}
	
	/*
	 * URL -  http://host:port/categories?catId=....
	 * Method -  DELETE
	 * payload -  request param
	 * resp success - DTO
	* resp error - DTO
	 * Desc - Hard delete category details
 */
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<?>deleteEmployee(@RequestParam() Long employeeId){
		System.out.println("in delete"+employeeId);
		try {
			
			return ResponseEntity.ok(
					employeeService.deleteEmployee(employeeId));
					
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
		}
	}
	
	
}
