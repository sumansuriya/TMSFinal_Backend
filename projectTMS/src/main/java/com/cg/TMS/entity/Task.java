package com.cg.TMS.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Task {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int taskId;
	private String taskName;
	private String taskStatus;
	private int projectid;
	private String projectName;
	
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Calendar deadLine;
	
	private int extraDays;
	
		
	@ManyToOne
	Employee emp;
	
	
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
    

	public Task() {
		super();
	}

	
	

	public Task(int taskId, String taskName, String taskStatus, int projectid, String projectName, Calendar startDate, Calendar deadLine, int extraDays,
			Employee emp) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskStatus = taskStatus;
		this.projectid = projectid;
		this.projectName = projectName;
		this.startDate = startDate;
		this.deadLine = deadLine;
		this.extraDays = extraDays;
		this.emp = emp;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Calendar deadLine) {
		 this.deadLine = deadLine;
	}

	public int getExtraDays() {
		return extraDays;
	}

	public void setExtraDays(int extraDays) {
		this.extraDays = extraDays;
	}
	

//To set the deadline
public void setDeadLineAuto(Calendar calen) {
	
	calen.add(Calendar.DAY_OF_MONTH, +3);
	setDeadLine(calen);
}



@Override
public String toString() {
	return "Task [taskId=" + taskId + ", taskName=" + taskName + ", taskStatus=" + taskStatus + ", projectid="
			+ projectid + ", projectName=" + projectName + ", startDate=" + startDate + ", deadLine=" + deadLine
			+ ", extraDays=" + extraDays + ", emp=" + emp + "]";
}









	

	

	
	








	
	
 

    
	


}
