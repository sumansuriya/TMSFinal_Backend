package com.cg.TMS.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.TMS.entity.Admin;
import com.cg.TMS.entity.Employee;

@Service
public interface IAdminProfileService {
	
	public String saveUsers(Admin admin);

	public Admin findadminById(int id);

	public void updateadmin(Admin admin);

	public Admin verifyUser(Admin ad);

    public 	List<Admin> getAllAdmins();
	

}
