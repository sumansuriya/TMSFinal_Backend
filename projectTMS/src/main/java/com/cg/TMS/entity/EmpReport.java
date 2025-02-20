package com.cg.TMS.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class EmpReport {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int reportid;
	 
   @OneToOne
   Employee emp;
   
  @OneToOne(cascade= {CascadeType.ALL})
  Task taskList;

public EmpReport() {
	super();
}



public Employee getEmp() {
	return emp;
}



public void setEmp(Employee emp) {
	this.emp = emp;
}



public EmpReport(Employee emp, Task taskList) {
	super();

	this.emp = emp;
	this.taskList = taskList;
}



public Task getTaskList() {
	return taskList;
}

public void setTaskList(Task taskList) {
	this.taskList = taskList;
}


public int getReportid() {
	return reportid;
}

public void setReportid(int reportid) {
	this.reportid = reportid;
}



@Override
public String toString() {
	return "EmpReport [reportid=" + reportid + ", emp=" + emp + ", taskList=" + taskList + "]";
}














}