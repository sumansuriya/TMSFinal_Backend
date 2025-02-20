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
import com.cg.TMS.services.IAdminTaskService;
import com.cg.TMS.services.AdminTaskService;
@CrossOrigin("http://localhost:3000/")
@RestController                 
@RequestMapping("/api/v1")      
public class AdminTaskController {

	@Autowired
	IAdminTaskService adminTaskService;
		
				
//Admin getting list of tasks
	    @GetMapping(path = "/task", produces = { "application/json" }) 
		public ResponseEntity<List<Task>> getAllTasks() {
			List<Task> taskList = adminTaskService.getAllTasks();
			return new ResponseEntity<List<Task>>(taskList, HttpStatus.OK);
		}
	    
//Admin adding a task
	    @PostMapping(path = "/task/add", consumes = {"application/json"})
		public ResponseEntity<Task> saveTasks(@RequestBody Task tsk){

			Task newTask = adminTaskService.saveTasks(tsk);

			return new ResponseEntity<Task>(newTask, HttpStatus.OK);

		}
	    
//Admin updating task details
	    @PutMapping(path = "/task/update", consumes = {"application/json"})
		public ResponseEntity<Task> updateTask(@RequestBody Task tsks) {
			adminTaskService.updateTask(tsks);
			Task task = adminTaskService.findTaskById(tsks.getTaskId());

			return new ResponseEntity<Task>(task, HttpStatus.OK);
		}

//Admin deleting a task by id
	    @DeleteMapping("/task/delete/{id}")
		public ResponseEntity<List<Task>> deleteUserById(@PathVariable("id") int id) {
			Task tasks = adminTaskService.findTaskById(id);

			if(tasks==null) {
				return new ResponseEntity<List<Task>>(HttpStatus.NOT_FOUND);
			}
			else {
				adminTaskService.deleteTaskById(id);
			}
			List<Task> tasksList = adminTaskService.getAllTasks();
			return new ResponseEntity<List<Task>>(tasksList, HttpStatus.OK);
		}
	 
}
