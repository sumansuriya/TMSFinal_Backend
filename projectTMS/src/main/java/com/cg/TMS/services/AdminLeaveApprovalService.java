package com.cg.TMS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.TMS.entity.Leave;
import com.cg.TMS.entity.Task;
import com.cg.TMS.exception.LeaveNotFoundException;
import com.cg.TMS.repository.IAdminTaskApprovalRepository;
import com.cg.TMS.repository.ILeaveRepository;
import com.cg.TMS.repository.ITaskRepository;
	
	@Service
	public class AdminLeaveApprovalService implements IAdminLeaveApprovalService{
		
	@Autowired
	ILeaveRepository approve;

	
		@Override
		public List<Leave> getAllLeaves() {
			// TODO Auto-generated method stub
			return approve.findAll();
		}

		@Override
		public Leave findLeaveById(int id) {
			// TODO Auto-generated method stub
			Optional<Leave> leave=approve.findById(id);
			if(leave.isEmpty()|| leave==null) {
				throw new LeaveNotFoundException("Leave Not Found For The Given ID: "+id);
			}
			return leave.get();
		}

		@Override
		public void updateLeave(Leave leave) {
			// TODO Auto-generated method stub
			
			Leave  findLeave = findLeaveById(leave.getLeaveid());
	
			findLeave.setApprovedleaves(leave.getApprovedleaves());
        
			findLeave.setBalanceLeaves(findLeave.getAssignedleaves() - findLeave.getApprovedleaves());
	
			if(findLeave.getApprovedleaves() >= 12)  
			{				
				if(findLeave.getLeavetype().equals("sick")) {
					findLeave.setLeaveStatus("Approved");					
				}
				else {
					findLeave.setLeaveStatus("rejected");
				}
			}
			else {
				findLeave.setLeaveStatus("Approved"); 
			}
			
			approve.save(findLeave);
			
	}

}
