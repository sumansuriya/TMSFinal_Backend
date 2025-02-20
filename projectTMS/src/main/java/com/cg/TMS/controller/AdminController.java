package com.cg.TMS.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.Task;
import com.cg.TMS.exception.TaskNotFoundException;
import com.cg.TMS.services.AdminService;
import com.cg.TMS.services.IAdminService;

@CrossOrigin("http://localhost:3000/")
@RestController                 
@RequestMapping("/api/v1")      
public class AdminController {

	@Autowired
	IAdminService adminService;

	
//Admin getting list of employees	
   @GetMapping(path = "/emp", produces = { "application/json" }) 
	public ResponseEntity<List<Employee>> getAllUsers() {
		List<Employee> userList = adminService.getAllUsers();
		return new ResponseEntity<List<Employee>>(userList, HttpStatus.OK);
	}

//Admin adding an employee
	@PostMapping(path = "/emp/add", consumes = {"application/json"})
	public ResponseEntity<String>saveUsers(@RequestBody Employee user){

		adminService.saveUsers(user);

		String msg= "Employee has been added successfully.";
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

//Admin updating an employee details
	@PutMapping(path = "/emp/update", consumes = {"application/json"})
	public ResponseEntity<Employee> updateUser(@RequestBody Employee users) {
		adminService.updateUser(users);
		Employee usr = adminService.findUserById(users.getEmpid());
		

		return new ResponseEntity<Employee>(usr, HttpStatus.OK);
	}

//Admin deleting an employee
	@DeleteMapping("/emp/delete/{id}")
	public ResponseEntity<List<Employee>> deleteUserById(@PathVariable("id") int id) {
		Employee users = adminService.findUserById(id);

		if(users==null) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
		}
		else {
			adminService.deleteUserById(id);
		}
		List<Employee> usersList = adminService.getAllUsers();
		return new ResponseEntity<List<Employee>>(usersList, HttpStatus.OK);
	}

	 
}