package com.cg.TMS.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.TMS.entity.Leave;

@Service
public interface IAdminLeaveApprovalService {
	
	public List<Leave> getAllLeaves();
	
	public Leave findLeaveById(int id);
	
	public void updateLeave(Leave leave);
	
	
}
