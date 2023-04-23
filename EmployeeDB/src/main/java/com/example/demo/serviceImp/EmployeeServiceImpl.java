package com.example.demo.serviceImp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.customexception.ResourceNotFoundException;
import com.example.demo.module.Employee;
import com.example.demo.repoOrDao.EmployeeRepo;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo repo;
	
	@Override
	public Employee addEmployee(Employee e) {
		return repo.save(e);
	}

	@Override
	public Employee getById(Integer eId) {
		return repo.findById(eId).orElseThrow(()-> new ResourceNotFoundException("Employee","id", eId));
	}

	@Override
	public List<Employee> getByDesignation(String designation) {
		return repo.getByDesignation(designation);
	}

	@Override
	public List<Employee> getByLessThanSal(double sal) {
		return repo.getByLessThanSal(sal);
	}

	@Override
	public Employee updateEmp(Employee e1) {
		Employee e= repo.findById(e1.geteId()).orElseThrow(null);
		if(e!=null) {
			e.seteName(e1.geteName());
			e.setDesignation(e1.getDesignation());
			e.setPhNo(e1.getPhNo());
			e.setSal(e1.getSal());
			return repo.save(e);
		}
		else {
			throw new ResourceNotFoundException("Employee","id",e.geteId());
		}
		
	}

	@Override
	public Employee deleteById(Integer eId) {
		Employee e= repo.findById(eId).orElseThrow(null);
		if(e!=null) {
			repo.deleteById(eId);
			return e;
		}
		else {
			 throw new ResourceNotFoundException("Employee","id",eId);
		}
	}
	
	
}
