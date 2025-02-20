package com.cg.TMS.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.cg.TMS.entity.EmpRequest;
@Service
public interface IEmployeeRequestService {

	public EmpRequest saveRequest(EmpRequest req);

	public List<EmpRequest> findrequestsByTaskId(int id);
	
	public void deleteRequestById(int id);
}
