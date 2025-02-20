package com.cg.TMS.services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.TMS.entity.Admin;
import com.cg.TMS.entity.EmpBench;
import com.cg.TMS.entity.Employee;
import com.cg.TMS.exception.UserNotFoundException;
import com.cg.TMS.repository.IAdminRepository;

@Service
public class AdminProfileService implements IAdminProfileService {
	
	@Autowired
	IAdminRepository repoo;

	@Override
	public String saveUsers(Admin admin) {
		// TODO Auto-generated method stub
		String msg;
       Admin newUser = admin;

       if(admin.getKey().equals("projecttms"))
       {
	      repoo.save(newUser);
	      msg="your registration is successful";
       }
       else {
           msg="invalid key entered";
       }
       return msg;
	}

	
	@Override
	public Admin findadminById(int id) {
		// TODO Auto-generated method stub
		Optional<Admin> user = repoo.findById(id);

		if(user.isEmpty() || user == null) {
			throw new UserNotFoundException("Admin details Not Found For The Given ID : " +id);
		}
		return user.get();
	 }
	
	
	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return repoo.findAll();
	}

	
	@Override
	public void updateadmin(Admin admin) {
		// TODO Auto-generated method stub
		Admin adm = findadminById(admin.getAdminid());
		adm.setPassword(admin.getPassword());
		
		repoo.save(adm);
		
	}
	
	
	@Override
	public Admin verifyUser(Admin ad) {
		
		Admin adm = repoo.findByUserNameAndPassword(ad.getUsername(), ad.getPassword());
	
		return adm;

	}
	
	
}
