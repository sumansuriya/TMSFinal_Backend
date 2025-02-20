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

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.Leave;
import com.cg.TMS.services.IAdminLeaveApprovalService;
import com.cg.TMS.services.IAdminService;
import com.cg.TMS.services.IEmpLeaveService;
@CrossOrigin("http://localhost:3000/")
@RestController                 
@RequestMapping("/api/v1")      
public class LeaveController {

	@Autowired
	IAdminLeaveApprovalService adminLeave;
	
	@Autowired
	IEmpLeaveService empleave;

//Employee getting leave status by id
    @GetMapping(path = "/leaves/{id}", produces = { "application/json" }) 
		public ResponseEntity<List<Leave>> findLivByTaskId(@PathVariable("id") int id) {
    	     List<Leave> leaves = empleave.findLivByTaskId(id);
			return new ResponseEntity<List<Leave>>(leaves, HttpStatus.OK);
	}
    
//Employee applying for leave
	@PostMapping(path ="/leave/add", consumes = {"application/json"})
	public ResponseEntity<Leave> saveLeave(@RequestBody Leave eleave){

		Leave leaveReq = empleave.saveLeave(eleave);

		return new ResponseEntity<Leave>(leaveReq, HttpStatus.OK);
     }

	
//Admin getting list of leave requests	
	  @GetMapping(path = "/emp/leave", produces = { "application/json" }) 
		public ResponseEntity<List<Leave>> getAllLeaves() {
			List<Leave> leaveList = adminLeave.getAllLeaves();
			
			return new ResponseEntity<List<Leave>>(leaveList, HttpStatus.OK);
		}

//Admin getting an employee leave request by id
	  @GetMapping(path = "/emp/leave/{id}", produces = { "application/json" }) 
			public ResponseEntity<Leave> findLeaveById(@PathVariable("id") int id) {
				Leave findleavereq = adminLeave.findLeaveById(id);
				return new ResponseEntity<Leave>(findleavereq, HttpStatus.OK);
			}
	  

//Admin approving/rejecting a leave request
		@PutMapping(path = "/emp/leave/update", consumes = {"application/json"})
		public ResponseEntity<List<Leave>> updateLeave(@RequestBody Leave leave) {
			adminLeave.updateLeave(leave);
			List<Leave> leavelist = adminLeave.getAllLeaves();

			return new ResponseEntity<List<Leave>>(leavelist, HttpStatus.OK);
		}
				
}
