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

import com.cg.TMS.entity.EmpBench;
import com.cg.TMS.entity.Task;
import com.cg.TMS.services.IEmployeeBenchService;
@CrossOrigin("http://localhost:3000/")
@RestController                 
@RequestMapping("/api/v1") 
public class EmpBenchController {
	
	@Autowired
	IEmployeeBenchService bench;
	
//Admin getting list of employees on bench
	 @GetMapping(path = "/bench", produces = { "application/json" }) 
		public ResponseEntity<List<EmpBench>> getAllEmps() {
			List<EmpBench> benchList = bench.getAllEmps();
			return new ResponseEntity<List<EmpBench>>(benchList, HttpStatus.OK);
		}
	 
	 
//Admin getting an employee on bench by id
	 @GetMapping(path = "/bench/emp/{id}", produces = { "application/json" }) 
		public ResponseEntity<EmpBench> findEmpByProjectId(@PathVariable("id") int id) {
			EmpBench emps = bench.findEmpByProjectid(id);
			return new ResponseEntity<EmpBench>(emps, HttpStatus.OK);
		}

}
