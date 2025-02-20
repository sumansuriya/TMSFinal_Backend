package com.cg.TMS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.EmpReport;
import com.cg.TMS.entity.EmpRequest;
import com.cg.TMS.entity.Task;
import com.cg.TMS.exception.RequestNotFoundException;
import com.cg.TMS.exception.TaskNotFoundException;
import com.cg.TMS.exception.UserNotFoundException;
import com.cg.TMS.repository.IAdminTaskApprovalRepository;

@Service
public class AdminTaskApprovalService implements IAdminTaskApprovalService {
	
@Autowired
IAdminTaskApprovalRepository approve;



@Override
public List<EmpRequest> getAllRequests() {
	// TODO Auto-generated method stub
	return approve.findAll();
	
}

@Override
public void updateRequest(EmpRequest request) {
	// TODO Auto-generated method stub
	EmpRequest  req = findRequestById(request.getRequestid());
	
	req.setStatus(request.getStatus());
	req.setReason(request.getReason());
	
	approve.save(req);
}

@Override
public EmpRequest findRequestById(int id) {
	// TODO Auto-generated method stub
	Optional<EmpRequest> tas = approve.findById(id);

	if(tas.isEmpty() || tas == null) {
		throw new RequestNotFoundException("Request Not Found For The Given ID : " +id);
	}
	return tas.get();
}



}
