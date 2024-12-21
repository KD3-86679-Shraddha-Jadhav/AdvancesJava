package com.blogs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee , Long> {

}
