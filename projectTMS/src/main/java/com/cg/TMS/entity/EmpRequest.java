package com.cg.TMS.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class EmpRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int requestid;
	
	private String status;
	private String reason;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate taskExtensionDate;

	@ManyToOne
	Task task;
	
	
	public EmpRequest() {
		super();
	}

		public EmpRequest(int requestid, String status, LocalDate taskExtensionDate, Task task, String reason) {
		super();
		this.requestid = requestid;
		this.status = status;
		this.taskExtensionDate = taskExtensionDate;
		this.task = task;
		this.reason=reason;
	}



	public String getReason() {
			return reason;
		}

	public void setReason(String reason) {
			this.reason = reason;
		}

	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public LocalDate getTaskExtensionDate() {
		return taskExtensionDate;
	}


	public void setTaskExtensionDate(LocalDate taskExtensionDate) {
		this.taskExtensionDate = taskExtensionDate;
	}


	public Task getTask() {
		return task;
	}


	public void setTask(Task task) {
		this.task = task;
	}

	
	@Override
	public String toString() {
		return "EmpRequest [requestid=" + requestid + ", status=" + status + ", reason=" + reason
				+ ", taskExtensionDate=" + taskExtensionDate + ", task=" + task + "]";
	}










	
	
	
}
