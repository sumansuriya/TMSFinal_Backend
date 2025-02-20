package com.cg.TMS.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Leave {
	 @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int leaveid;
	private int  assignedleaves;
	private int approvedleaves;
	private int balanceLeaves;
	private String reason;
	private int leaveduration;
	private String leavetype;
	private String leaveStatus;
		
		public Leave() {
			super();
		}

		
		@ManyToOne
		Task tasks;
		
		public Leave(int leaveid, int assignedleaves, int approvedleaves, int balanceLeaves, String reason,
				int leaveduration, String leavetype, String leaveStatus, Employee emp, Task tasks) {
			super();
			this.leaveid = leaveid;
			this.assignedleaves = assignedleaves;
			this.approvedleaves = approvedleaves;
			this.balanceLeaves = balanceLeaves;
			this.reason = reason;
			this.leaveduration = leaveduration;
			this.leavetype = leavetype;
			this.leaveStatus=leaveStatus;
			this.tasks=tasks;
		}


		public Task getTasks() {
			return tasks;
		}

		public void setTasks(Task tasks) {
			this.tasks = tasks;
		}



		public int getLeaveid() {
			return leaveid;
		}


		public void setLeaveid(int leaveid) {
			this.leaveid = leaveid;
		}


		public int getAssignedleaves() {
			return assignedleaves;
		}


		public void setAssignedleaves(int assignedleaves) {
			this.assignedleaves = assignedleaves;
		}


		public int getApprovedleaves() {
			return approvedleaves;
		}


		public void setApprovedleaves(int approvedleaves) {
			this.approvedleaves = approvedleaves;
		}


		public int getBalanceLeaves() {
			return balanceLeaves;
		}


		public void setBalanceLeaves(int balanceLeaves) {
			this.balanceLeaves = balanceLeaves;
		}


		public String getReason() {
			return reason;
		}


		public void setReason(String reason) {
			this.reason = reason;
		}


		public int getLeaveduration() {
			return leaveduration;
		}


		public void setLeaveduration(int leaveduration) {
			this.leaveduration = leaveduration;
		}


		public String getLeavetype() {
			return leavetype;
		}


		public void setLeavetype(String leavetype) {
			this.leavetype = leavetype;
		}


		public String getLeaveStatus() {
			return leaveStatus;
		}


		public void setLeaveStatus(String leaveStatus) {
			this.leaveStatus = leaveStatus;
		}


		@Override
		public String toString() {
			return "Leave [leaveid=" + leaveid + ", assignedleaves=" + assignedleaves + ", approvedleaves="
					+ approvedleaves + ", balanceLeaves=" + balanceLeaves + ", reason=" + reason + ", leaveduration="
					+ leaveduration + ", leavetype=" + leavetype + ", leaveStatus=" + leaveStatus + ", tasks=" + tasks
					+ "]";
		}


		
		
		

		
		
		




















}