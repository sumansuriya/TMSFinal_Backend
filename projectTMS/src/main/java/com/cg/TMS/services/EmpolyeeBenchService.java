package com.cg.TMS.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.EmpBench;
import com.cg.TMS.entity.Task;
import com.cg.TMS.exception.ProjectIdNotFoundException;
import com.cg.TMS.exception.TaskNotFoundException;
import com.cg.TMS.exception.UserNotFoundException;
import com.cg.TMS.repository.IBenchRepository;
import com.cg.TMS.repository.ITaskRepository;
import com.cg.TMS.repository.IUserRepository;
@Service
public class EmpolyeeBenchService implements IEmployeeBenchService {
	@Autowired
	IBenchRepository repo3;
	@Autowired
	IUserRepository repo1;
	
	@Autowired
	ITaskRepository repo2;
	
	
	@Autowired
	IEmpReportService adm;
	@Autowired
	AdminTaskService ad;
	
	@Override

	public EmpBench findEmpByProjectid(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Employee e = repo1.getById(id);
		
		EmpBench ems = repo3.findBenchRecord(e);

		Optional<EmpBench> user = Optional.ofNullable(ems);		
		
		EmpBench eb = new EmpBench();
		
		if(user.isEmpty() || user == null) {
			throw new UserNotFoundException("Employee not found For The Given ID : " +id);
		}
		else {
			
			
			if(user.get().getEmpStatus().equals("employee is on bench")) {
				eb = user.get();
			}
			else {
			  eb= user.get();    
			}
		}
       
        return eb;
	}
	
	@Override
	public List<EmpBench> getAllEmps() {
		// TODO Auto-generated method stub
		 List<EmpBench> ebcd = repo3.findAll();
		 
		List<EmpBench> bList = new ArrayList<EmpBench>();
		
            if(ebcd.isEmpty() || ebcd == null) {
			  throw new UserNotFoundException("No Employees on Bench");
		       }
		    else {
		        for(EmpBench users : ebcd){
	
		            if(users.getEmpStatus().equals("employee is on bench")) {
			             bList.add(users);
		      	    }
		              
		         }
		    }
		   return bList;
	}
}

