package com.cg.TMS.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.TMS.entity.EmpRequest;
import com.cg.TMS.entity.Leave;

@Service
public interface IEmpLeaveService {
	
	public Leave saveLeave(Leave req);
	
	public List<Leave> findLivByTaskId(int id);
}