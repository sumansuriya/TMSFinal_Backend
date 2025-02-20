package com.cg.TMS.controller;

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
import com.cg.TMS.entity.EmpRequest;
import com.cg.TMS.entity.Task;
import com.cg.TMS.services.IAdminTaskApprovalService;
import com.cg.TMS.services.IEmployeeRequestService;
@CrossOrigin("http://localhost:3000/")
@RestController                 
@RequestMapping("/api/v1")
public class TaskApprovalController {
	
     @Autowired
     IAdminTaskApprovalService taskapprove;

     @Autowired
     IEmployeeRequestService RequestService;


//Employee getting his time Extension status
@GetMapping(path = "/request/task/{id}", produces = { "application/json" }) 
public ResponseEntity<List<EmpRequest>> findrequestsByTaskId(@PathVariable("id") int id){
	List<EmpRequest> reqList = RequestService.findrequestsByTaskId(id);
	return new ResponseEntity<List<EmpRequest>>(reqList, HttpStatus.OK);
}



//Employee applying for time extension 
@PostMapping(path = "/request", consumes = {"application/json"})
public ResponseEntity<EmpRequest> saveRequest(@RequestBody EmpRequest req){

	EmpRequest reqs = RequestService.saveRequest(req);

	return new ResponseEntity<EmpRequest>(reqs, HttpStatus.OK);

   }


//Admin getting an employee's time extension request
@GetMapping(path = "/request/view/{id}", produces = { "application/json" }) 
public ResponseEntity<EmpRequest> findRequestById (@PathVariable("id") int id){
	EmpRequest req = taskapprove.findRequestById(id);
	
	return new ResponseEntity<EmpRequest>(req, HttpStatus.OK);
	
	}


//Admin getting employees list who have applied for time extension 
@GetMapping(path = "/request/view", produces = { "application/json" }) 
	public ResponseEntity<List<EmpRequest>> getAllRequests() {
		List<EmpRequest> reqList = taskapprove.getAllRequests();
		return new ResponseEntity<List<EmpRequest>>(reqList, HttpStatus.OK);
	}


//Admin approving/rejecting time extension request
@PutMapping(path = "/request/update", consumes = {"application/json"})
public ResponseEntity<List<EmpRequest>> updateUser(@RequestBody EmpRequest reqs) {
	taskapprove.updateRequest(reqs);
	List<EmpRequest> reqList = taskapprove.getAllRequests();

	return new ResponseEntity<List<EmpRequest>>(reqList, HttpStatus.OK);
   }


//Employee can delete his requests
@DeleteMapping("/request/delete/{id}")
public ResponseEntity<List<EmpRequest>> deleteUserById(@PathVariable("id") int id) {
	EmpRequest reqs = taskapprove.findRequestById(id);

	if(reqs==null) {
		return new ResponseEntity<List<EmpRequest>>(HttpStatus.NOT_FOUND);
	}
	else {
		RequestService.deleteRequestById(id);
	}
	List<EmpRequest> usersList = taskapprove.getAllRequests();
	
	return new ResponseEntity<List<EmpRequest>>(usersList, HttpStatus.OK);
}


}
