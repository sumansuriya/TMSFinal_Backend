package com.cg.TMS.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EmpTaskAssign {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
		
	public EmpTaskAssign() {
		super();
	}
	
	  @OneToOne
	  Employee empl;
	   
	  @OneToOne(cascade= {CascadeType.ALL})
	  Task taslist;


	
	public EmpTaskAssign(Employee emp, Task taskList) {
		super();
	
		this.empl = emp;
		this.taslist = taskList;
	}

	 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmp() {
		return empl;
	}

	public void setEmp(Employee emp) {
		this.empl = emp;
	}

	public Task getTaskList() {
		return taslist;
	}

	public void setTaskList(Task taskList) {
		this.taslist = taskList;
	}

	@Override
	public String toString() {
		return "EmpTaskAssign [id=" + id + ", empl=" + empl + ", taslist=" + taslist + "]";
	}

	
  
	  

}
