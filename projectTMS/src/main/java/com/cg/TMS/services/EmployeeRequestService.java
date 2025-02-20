package com.cg.TMS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.TMS.entity.EmpRequest;
import com.cg.TMS.entity.Task;
import com.cg.TMS.exception.RequestNotFoundException;
import com.cg.TMS.exception.TaskNotFoundException;
import com.cg.TMS.exception.UserNotFoundException;
import com.cg.TMS.repository.IEmpRequestRepository;

@Service
public class EmployeeRequestService implements IEmployeeRequestService {

	@Autowired
	IEmpRequestRepository request; 
	@Autowired
	IAdminTaskService ser;
	
	
	@Override
	public EmpRequest saveRequest(EmpRequest req) {
		
		EmpRequest newrequest = req;
		
		newrequest.setStatus("Pending");
		newrequest.setReason(req.getReason());
		
		request.save(newrequest);
		
		return newrequest;
	}

	

	@Override
	public List<EmpRequest> findrequestsByTaskId(int id) {
		// TODO Auto-generated method stub
		Task ts = ser.findTaskById(id);
		return request.findAllByTaskId(ts);
	}
	@Override
	public void deleteRequestById(int id) {
		// TODO Auto-generated method stub
		request.deleteById(id);
	}
	

}
