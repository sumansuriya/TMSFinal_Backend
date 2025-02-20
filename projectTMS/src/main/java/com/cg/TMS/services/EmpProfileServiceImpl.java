package com.cg.TMS.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.TMS.entity.Admin;
import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.Task;
import com.cg.TMS.exception.UserNotFoundException;
import com.cg.TMS.repository.IUserRepository;

@Service
public class EmpProfileServiceImpl implements EmpProfileService{

	
	@Autowired
	IUserRepository userrepo;
	
	@Override
	public Employee findProfileById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> emp = userrepo.findById(id);

		if(emp.isEmpty() || emp == null) {
			throw new UserNotFoundException("User Not Found For The Given ID : " +id);
		}
		return emp.get();

	}

	@Override
	public void updateProfile(Employee emp) {
		// TODO Auto-generated method stub
		Employee  findprofile = findProfileById(emp.getEmpid());
		
		findprofile.setPassword(emp.getPassword());
		findprofile.setContactNo(emp.getContactNo());
		findprofile.setFirstname(emp.getFirstname());
		findprofile.setLastname(emp.getLastname());
		findprofile.setUsername(emp.getUsername());
		
	      userrepo.save(findprofile);

	}

	
	@Override
	public Employee verifyEmp(Employee emps) {
		
		Employee emse = userrepo.findByUsernamePassword(emps.getUsername(), emps.getPassword());
	
		return emse;

	}
	
	
}
