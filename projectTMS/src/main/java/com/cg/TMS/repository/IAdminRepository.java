package com.cg.TMS.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.cg.TMS.entity.Admin;
import com.cg.TMS.entity.EmpBench;
import com.cg.TMS.entity.Employee;


@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer>{
	
	@Query("from Admin u where u.username=?1 and u.password=?2")
	public Admin findByUserNameAndPassword(String username, String password);

}
