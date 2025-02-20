package com.cg.TMS.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminid;
	
	private String firstname;
	private String lastname;
	private String username;
	
	
	protected String password;
	
	private String adminmail;
	private String key;
	
	public Admin() {
		   super();
	  }

	

	public Admin(int adminid, String firstname, String lastname, String username, String password, String adminmail,
			String key) {
		super();
		this.adminid = adminid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.adminmail = adminmail;
		this.key = key;
	}



	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminmail() {
		return adminmail;
	}

	public void setAdminmail(String adminmail) {
		this.adminmail = adminmail;
	}
	

	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}



	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", password=" + password + ", adminmail=" + adminmail + ", key=" + key + "]";
	}



	

}

