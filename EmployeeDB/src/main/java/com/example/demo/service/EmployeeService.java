package com.example.demo.service;

import java.util.List;
import com.example.demo.module.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee e);
	
	Employee getById(Integer eId);
	
	List<Employee> getByDesignation(String designation);
	
	List<Employee> getByLessThanSal(double sal);
	
	Employee updateEmp(Employee e);
	
	Employee deleteById(Integer eId);
}
