package com.cg.TMS.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.EmpRequest;

@Service
public interface IAdminTaskApprovalService {

	public List<EmpRequest> getAllRequests();
	
	public void updateRequest(EmpRequest user);
	
	public EmpRequest findRequestById(int id);
	
}
