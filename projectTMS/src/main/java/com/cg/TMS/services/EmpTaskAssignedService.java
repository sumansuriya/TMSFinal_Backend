package com.cg.TMS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.Task;
import com.cg.TMS.exception.UserNotFoundException;
import com.cg.TMS.repository.ITaskRepository;
import com.cg.TMS.repository.IUserRepository;

@Service
public class EmpTaskAssignedService implements IEmpTaskAssignedService {

	@Autowired
	ITaskRepository repor2;
	@Autowired
	IUserRepository us2;
	
	@Override
	public List<Task> FindTasksByEmpId(int id) {
		// TODO Auto-generated method stub
		
		Employee empreport = us2.getById(id);
        List<Task> allTasks = repor2.getTsks(empreport);
        
		if(empreport == null) {
			throw new UserNotFoundException("Report Not Found For The Given ID : " +id);
		}
		return allTasks; 
		
	}

}
