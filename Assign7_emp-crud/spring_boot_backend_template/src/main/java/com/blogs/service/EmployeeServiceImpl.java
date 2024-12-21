package com.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.custom_exceptions.ResourceNotFoundException;
import com.blogs.dao.EmployeeDao;
import com.blogs.dto.ApiResponse;
import com.blogs.entities.Employee;



@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployess() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	public String addNewEmployee(Employee employee) {
	    Employee persistEmployee = employeeDao.save(employee);
	    
		return "Added new employee"+ persistEmployee;
	}

	
	@Override
	public Employee getEmployeeDetails(Long empId) {
		// TODO Auto-generated method stub
		return employeeDao.findById(empId).orElseThrow(()-> new ResourceNotFoundException("invalid employee id"));
	}
	
	@Override
	public Employee updateEmployee(Employee detachedEmp) {
		//check if exists
		if(employeeDao.existsById(detachedEmp.getId())) {
		return employeeDao.save(detachedEmp);
		}
		throw new ResourceNotFoundException("Invalid emp id!!");
	}

	@Override
	public ApiResponse deleteEmployee(Long employeeId) {
		if(employeeDao.existsById(employeeId)) {
			employeeDao.deleteById(employeeId);
			return new ApiResponse("Deleted employee details");
			
		}
		throw new ResourceNotFoundException("Invalid employee Id!!");
	}

	

	

}
