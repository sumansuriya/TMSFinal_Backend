package com.cg.TMS.entity;

	import javax.persistence.CascadeType;
import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToOne;
	import javax.persistence.Table;

	@Entity
	public class EmpBench {
		
		@Id	
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int bid;
		private String empStatus;

		@OneToOne
		Employee emp;
		

		public EmpBench() {
		super();
		 }

	
		public EmpBench(String empStatus, Employee emp) {
			super();
		
			this.empStatus = empStatus;
			this.emp = emp;
		}


		public int getBid() {
			return bid;
		}

		public void setBid(int bid) {
			this.bid = bid;
		}

		public String getEmpStatus() {
			return empStatus;
		}

		public void setEmpStatus(String empStatus) {
			this.empStatus = empStatus;
		}

		public Employee getEmp() {
			return emp;
		}

		public void setEmp(Employee emp) {
			this.emp = emp;
		}



		@Override
		public String toString() {
			return "EmpBench [bid=" + bid + ", empStatus=" + empStatus + ", emp=" + emp + "]";
		}

			
		  
	}


