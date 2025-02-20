package com.cg.TMS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.EmpReport;
import com.cg.TMS.entity.Task;
import com.cg.TMS.exception.UserNotFoundException;
import com.cg.TMS.repository.IEmpReportRepository;
import com.cg.TMS.repository.ITaskRepository;
import com.cg.TMS.repository.IUserRepository;

@Service
public class EmpReportService implements IEmpReportService{

	@Autowired
	IEmpReportRepository report2;
	@Autowired
	ITaskRepository repor;
	@Autowired
	IUserRepository us;
	


	@Override
	public List<Task> getAllTasksByEmpId(int id) {
		// TODO Auto-generated method stub
		Employee empreport = us.getById(id);
        List<Task> tsks = repor.getTsks(empreport);
        
		if(empreport == null) {
			throw new UserNotFoundException("Report Not Found For The Given ID : " +id);
		}
		return tsks; 
	}
}
