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

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.EmpReport;
import com.cg.TMS.entity.Task;
import com.cg.TMS.services.IAdminReportService;
import com.cg.TMS.services.IAdminService;
import com.cg.TMS.services.IAdminTaskService;
import com.cg.TMS.services.IEmpReportService;
@CrossOrigin("http://localhost:3000/")
@RestController                 
@RequestMapping("/api/v1")      
public class ReportController {

	@Autowired
	IAdminReportService adminreport;
	
	@Autowired
	IEmpReportService empreport;
	
	
	@Autowired
	IAdminTaskService emp;
	
//Employee getting his report
	  @GetMapping(path = "/report/{id}", produces = { "application/json" }) 
			public ResponseEntity<List<Task>> findRepoById(@PathVariable("id") int id) {
		        List<Task> userreport = empreport.getAllTasksByEmpId(id);
				return new ResponseEntity<List<Task>>(userreport, HttpStatus.OK);
			}
	  
	  
//Admin getting reports of all employees		  
	   @GetMapping(path = "/report/view", produces = { "application/json" }) 
		public ResponseEntity<List<EmpReport>> getAllReports() {
			List<EmpReport> reportList = adminreport.getAllReports(); 
			return new ResponseEntity<List<EmpReport>>(reportList, HttpStatus.OK);
		}

	   
//Admin getting report of an employee	   
	    @GetMapping(path = "/report/view/{id}", produces = { "application/json" }) 
		public ResponseEntity<List<Task>> findReportById(@PathVariable("id") int id) {
			List<Task> emreport = empreport.getAllTasksByEmpId(id);
			return new ResponseEntity<List<Task>>(emreport, HttpStatus.OK);
		}

}
