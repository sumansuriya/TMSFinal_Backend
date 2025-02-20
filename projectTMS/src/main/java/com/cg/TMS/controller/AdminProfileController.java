package com.cg.TMS.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import com.cg.TMS.entity.Task;
import com.cg.TMS.services.AdminProfileService;
import com.cg.TMS.services.IAdminProfileService;
@CrossOrigin("http://localhost:3000/")
@RestController                 
@RequestMapping("/api/v1")
public class AdminProfileController {
	
	@Autowired
	IAdminProfileService repoo;
	
	
	@GetMapping(path = "/admin/profile/{id}", produces = { "application/json" }) 
	public ResponseEntity<Admin> findadminById(@PathVariable("id") int id) {
		Admin user = repoo.findadminById(id);
		return new ResponseEntity<Admin>(user, HttpStatus.OK);
	}
	 @GetMapping(path = "/admin/profile", produces = { "application/json" }) 
		public ResponseEntity<List<Admin>> getAllAdmins(){
			List<Admin> AdminList = repoo.getAllAdmins();
			return new ResponseEntity<List<Admin>>(AdminList, HttpStatus.OK);
		}
	
	@PutMapping(path = "/admin/profile/update", consumes = {"application/json"})
	public ResponseEntity<Admin> updateadmin(@RequestBody Admin admin) {
		repoo.updateadmin(admin);
		Admin admi = repoo.findadminById(admin.getAdminid());


		return new ResponseEntity<Admin>(admi, HttpStatus.OK);
	}
	@PostMapping(path = "/login", consumes = {"application/json"})
	public ResponseEntity<Admin> verifyUser(@RequestBody Admin ad) {
		Admin e = repoo.verifyUser(ad);
		return new ResponseEntity<Admin>(e, HttpStatus.OK);
	}
	
	@PostMapping(path = "/", consumes = {"application/json"})
	public ResponseEntity<String> saveUser(@Valid @RequestBody Admin adm){

		String newadm = repoo.saveUsers(adm);

		return new ResponseEntity<String>(newadm, HttpStatus.OK);

	}
	

}

