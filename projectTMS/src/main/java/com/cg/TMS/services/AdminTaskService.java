package com.cg.TMS.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
import com.cg.TMS.repository.IEmpTaskAssignedRepository;
import com.cg.TMS.repository.ITaskRepository;
import com.cg.TMS.repository.IUserRepository;

@Service
public class AdminTaskService implements IAdminTaskService {

	@Autowired
	ITaskRepository repo2;
	@Autowired
	IEmpReportRepository repo3;
	@Autowired
	IEmpTaskAssignedRepository repo4;
	@Autowired
	IBenchRepository repo5;
	@Autowired
	IAdminService admn;
	@Autowired
	IUserRepository repo6;

	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return repo2.findAll();
	}

	
	@Override
	public Task saveTasks(Task task) {
		// TODO Auto-generated method stub
		Task newTasks = task;
		
          newTasks.setTaskStatus("open");
          newTasks.setExtraDays(0);
		  
		 Calendar cal = Calendar.getInstance();
		 newTasks.setDeadLineAuto(cal.getInstance());

		repo2.save(newTasks);
		
		EmpReport emp = new EmpReport(task.getEmp(), task);
		repo3.save(emp);
		
		EmpTaskAssign em = new EmpTaskAssign(task.getEmp(), task);
		repo4.save(em);
		
		repo5.updateStatus("employee is on project", task.getEmp());
	
		
		
		
		return newTasks;
		
	} 

	@Override
	public Task findTaskById(int id) {
		// TODO Auto-generated method stub
		Optional<Task> task = repo2.findById(id);

		if(task.isEmpty() || task == null) {
			throw new TaskNotFoundException("Task Not Found For The Given ID : " +id);
		}
		return task.get();
	}

	
	@Override
	public void updateTask(Task task) {
//		// TODO Auto-generated method stub

		Task  findtask = findTaskById(task.getTaskId());
		
		findtask.setTaskStatus("pending");
		
		findtask.setProjectid(task.getProjectid());
		findtask.setProjectName(task.getProjectName());
		findtask.setExtraDays(task.getExtraDays());
		
	
	    repo2.save(findtask);
	}


	@Override
	public void deleteTaskById(int id) {
		// TODO Auto-generated method stub
		
		 Task ep = findTaskById(id);
		
		 repo5.updateStatus("employee is on bench", ep.getEmp());
		 
		 EmpReport ems = repo3.findEmpReportRecord(ep);

     	 EmpTaskAssign em = repo4.findEmpTaskRecord(ep);
		 
		 repo3.deleteById(ems.getReportid());
	
		 repo4.deleteById(em.getId());
		 
        }


}


