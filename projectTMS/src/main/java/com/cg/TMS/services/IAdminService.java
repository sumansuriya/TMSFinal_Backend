package com.cg.TMS.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.Task;
import com.cg.TMS.exception.TaskNotFoundException;

@Service
public interface IAdminService {

	public List<Employee> getAllUsers();

	public Employee saveUsers(Employee user);

	public Employee findUserById(int id);

	public void updateUser(Employee user);

	public void deleteUserById(int id);

	

	
}
