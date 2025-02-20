package com.cg.TMS.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empid;
	
	private String username;
	private String firstname;
	private String lastname;
	private String empmail;
	
	protected String password;
	
	private String empDeptName;
	private String designation;
	private String location;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate empHireDate;
	
	private long contactNo;
	
		
	
    public Employee() {
	   super();
     }

public Employee(int empid, String username, String firstname, String lastname, String empmail, String password,
	          String empDeptName, String designation, String location, LocalDate empHireDate, long contactNo)  {
	super();
	this.empid = empid;
	this.username = username;
	this.firstname = firstname;
	this.lastname = lastname;
	this.empmail = empmail;
	this.password = password;
	this.empDeptName = empDeptName;
	this.designation = designation;
	this.location = location;
	this.empHireDate = empHireDate;
	this.contactNo = contactNo;
   }


public int getEmpid() {
	return empid;
}

public void setEmpid(int empid) {
	this.empid = empid;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getEmpmail() {
	return empmail;
}

public void setEmpmail(String empmail) {
	this.empmail = empmail;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmpDeptName() {
	return empDeptName;
}

public void setEmpDeptName(String empDeptName) {
	this.empDeptName = empDeptName;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public LocalDate getEmpHireDate() {
	return empHireDate;
}

public void setEmpHireDate(LocalDate empHireDate) {
	this.empHireDate = empHireDate;
}

public long getContactNo() {
	return contactNo;
}

public void setContactNo(long contactNo) {
	this.contactNo = contactNo;
}



@Override
public String toString() {
	return "Employee [empid=" + empid + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
			+ ", empmail=" + empmail + ", password=" + password + ", empDeptName=" + empDeptName + ", designation="
			+ designation + ", location=" + location + ", empHireDate=" + empHireDate + ", contactNo=" + contactNo
			+ "]";
}













	
}
