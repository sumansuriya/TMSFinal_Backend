package com.cg.TMS.services;

import org.springframework.stereotype.Service;

import com.cg.TMS.entity.Employee;

@Service
public interface EmpProfileService {

	public Employee findProfileById(int id);
	
	public void updateProfile(Employee emp);
	
	public Employee verifyEmp(Employee emps);
}
