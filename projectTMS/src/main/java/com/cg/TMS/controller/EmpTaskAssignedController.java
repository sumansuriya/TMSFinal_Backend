package com.cg.TMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.TMS.entity.Task;
import com.cg.TMS.repository.IEmpTaskAssignedRepository;
import com.cg.TMS.services.IAdminTaskService;
import com.cg.TMS.services.IEmpTaskAssignedService;
@CrossOrigin("http://localhost:3000/")
@RestController                 
@RequestMapping("/api/v1")
public class EmpTaskAssignedController {

	@Autowired
	IAdminTaskService emp;
	
	@Autowired
	IEmpTaskAssignedService tskassign;
	
//Employee getting his tasks
	  @GetMapping(path = "/work/{id}", produces = { "application/json" }) 
			public ResponseEntity<List<Task>> findRepoById(@PathVariable("id") int id) {
		        List<Task> usertasks = tskassign.FindTasksByEmpId(id);
				return new ResponseEntity<List<Task>>(usertasks, HttpStatus.OK);
			}
	  

}
