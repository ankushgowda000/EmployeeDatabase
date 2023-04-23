package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.module.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService ser;
	
	@PostMapping("addEmployee")
	ResponseEntity<Employee> addEmployee(@RequestBody Employee e){
		return new ResponseEntity<Employee>(ser.addEmployee(e),HttpStatus.CREATED);
	}
	
//	localhost:8080/getById
	@GetMapping("getById")
	ResponseEntity<Employee> getById(@RequestHeader Integer eId){
		return new ResponseEntity<Employee>(ser.getById(eId),HttpStatus.FOUND);
	}
	
	@GetMapping("getByDesignation")
	ResponseEntity<List<Employee>> getByDesignation(@RequestHeader String designation){
		return new ResponseEntity<List<Employee>>(ser.getByDesignation(designation),HttpStatus.FOUND);
	}
	
	@GetMapping("getByLessThanSal")
	ResponseEntity<List<Employee>> getByLessThanSal(@RequestHeader Double sal){
		return new ResponseEntity<List<Employee>>(ser.getByLessThanSal(sal),HttpStatus.FOUND);
	}
	
	@PutMapping("updateEmp")
	ResponseEntity<Employee> updateEmp(@RequestBody Employee e){
		return new ResponseEntity<Employee>(ser.updateEmp(e),HttpStatus.OK);
	}
	
	@DeleteMapping("deletetById")
	ResponseEntity<Employee> deleteById(@RequestParam Integer eId){
		return new ResponseEntity<Employee>(ser.deleteById(eId),HttpStatus.OK);
	}
	
	
}
