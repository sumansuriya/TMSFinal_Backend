package com.cg.TMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.TMS.entity.Admin;
import com.cg.TMS.entity.Employee;
import com.cg.TMS.services.EmpProfileService;
@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api/v1")
public class EmpProfileController {
	
	@Autowired
    EmpProfileService empro;

//Employee getting his profile by id
	  @GetMapping(path = "/emp/profile/{id}", produces = { "application/json" }) 
		public ResponseEntity<Employee> findProfileById(@PathVariable("id") int id) {
			Employee user = empro.findProfileById(id);
			return new ResponseEntity<Employee>(user, HttpStatus.OK);
		}
	  

//Employee updating his profile details
	  @PutMapping(path = "/emp/profile/update", consumes = {"application/json"})
		public ResponseEntity<Employee> updateProfile(@RequestBody Employee user) {
			empro.updateProfile(user);
			Employee emp = empro.findProfileById(user.getEmpid());
	

			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}

//Employee login using his details	  
	  @PostMapping(path = "/emp/login", consumes = {"application/json"})
		public ResponseEntity<Employee> verifyUser(@RequestBody Employee emps) {
			Employee e = empro.verifyEmp(emps);
			return new ResponseEntity<Employee>(e, HttpStatus.OK);
		}
}
