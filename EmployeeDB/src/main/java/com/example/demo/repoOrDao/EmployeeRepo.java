package com.example.demo.repoOrDao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.module.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	@Query(value="select * from Employee where designation=?1",nativeQuery = true)
	List<Employee> getByDesignation(String designation);
	
	@Query(value="select * from Employee where sal<=?1",nativeQuery = true)
	List<Employee> getByLessThanSal(Double sal);
	
	
	
}
