package com.cg.TMS.services;

	import java.util.List;
import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.TMS.entity.EmpRequest;
	import com.cg.TMS.entity.Leave;
import com.cg.TMS.entity.Task;
import com.cg.TMS.exception.LeaveNotFoundException;
	import com.cg.TMS.repository.ILeaveRepository;

	@Service
	public class EmpLeaveService implements IEmpLeaveService{
		
		
	@Autowired
	ILeaveRepository leave;
	@Autowired
	IAdminTaskService tasser;

		@Override
		public  Leave saveLeave(Leave req) {
			// TODO Auto-generated method stub
			Leave newrequest = req;

			newrequest.setLeaveStatus("Approval pending for Leave");
			newrequest.setAssignedleaves(12);
			
			newrequest.setBalanceLeaves(12);
			
			newrequest.setLeavetype(req.getLeavetype());
			newrequest.setReason(req.getReason());
			newrequest.setLeaveduration(req.getLeaveduration());
			
			leave.save(newrequest);
			
			return newrequest;
		}

		@Override
		public List<Leave> findLivByTaskId(int id) throws LeaveNotFoundException  {
			// TODO Auto-generated method stub
			Task ts = tasser.findTaskById(id); 
			List<Leave> leaveList = leave.leavesRecord(ts);
					
					return leaveList;
		}

		 
}
