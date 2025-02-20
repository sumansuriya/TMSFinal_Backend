package com.cg.TMS.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.TMS.entity.EmpBench;
import com.cg.TMS.entity.EmpReport;
import com.cg.TMS.entity.EmpTaskAssign;
import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.Task;
import com.cg.TMS.exception.TaskNotFoundException;
import com.cg.TMS.exception.UserNotFoundException;
import com.cg.TMS.repository.IBenchRepository;
import com.cg.TMS.repository.IEmpReportRepository;
import com.cg.TMS.repository.IEmpRequestRepository;
import com.cg.TMS.repository.IEmpTaskAssignedRepository;
import com.cg.TMS.repository.ILeaveRepository;
import com.cg.TMS.repository.ITaskRepository;
import com.cg.TMS.repository.IUserRepository;

@Service
public class AdminService implements IAdminService {

	@Autowired
	IUserRepository repo;
    @Autowired
    IBenchRepository repo2;
    @Autowired
    ITaskRepository repo3;
    @Autowired
    IEmpReportRepository repo4;
    @Autowired
    IEmpTaskAssignedRepository repo5;
    @Autowired
    IEmpRequestRepository repo6;
    @Autowired
    ILeaveRepository repo7;
    
    @Autowired
    IEmployeeBenchService ebservice;
	
	
	@Override
	public List<Employee> getAllUsers() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}


	@Override
	public Employee saveUsers(Employee user) {
		// TODO Auto-generated method stub
		
		Employee newUsers = user;
		
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!@#$%^&*<>?";
		String pasw = RandomStringUtils.random( 8, characters );

		newUsers.setPassword(pasw);

		repo.save(newUsers);

		
		EmpBench ems = new EmpBench();
		ems.setEmpStatus("employee is on bench");
		EmpBench emsm = new EmpBench(ems.getEmpStatus(), user);
		repo2.save(emsm);
		
		return newUsers;
	}



	@Override
	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		
		Employee e = findUserById(id);
		
		repo4.deleteReportsbyEmpId(e);
		
		List<Task> t = repo3.getTsks(e);
		
		 int ab = t.size();
		
		for(ab=0; ab<t.size(); ab++)
		{
			repo6.deleteRequestbyTaskId(t.get(ab));
			repo7.deleteLeavebyTaskId(t.get(ab));
	    }
	
		
        repo5.deleteTaskRecordsbyEmpId(e);
	     
	     	    	     
	     repo3.deleteTasksbyEmpId(e);
	     
	     EmpBench eb = repo2.findBenchRecord(e);
	     
	     repo2.deleteById(eb.getBid());
	     
	     repo.deleteById(id);
			    				
		
	}

	
	@Override
	public Employee findUserById(int id) throws UserNotFoundException{
		// TODO Auto-generated method stub
		Optional<Employee> user = repo.findById(id);

		if(user.isEmpty() || user == null) {
			throw new UserNotFoundException("User Not Found For The Given ID : " +id);
		}
		return user.get();
     }
		
	    @Override
		public void updateUser(Employee user) {
			// TODO Auto-generated method stub

			Employee emp = findUserById(user.getEmpid());
			
			emp.setEmpDeptName(user.getEmpDeptName());
			emp.setDesignation(user.getDesignation());
			emp.setEmpmail(user.getEmpmail());
			emp.setLocation(user.getLocation());
			
			repo.save(emp);
		}

	    
}

 
