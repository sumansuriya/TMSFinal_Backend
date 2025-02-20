package com.cg.TMS.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.TMS.entity.EmpBench;
import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.Task;

@Repository
public interface IBenchRepository extends JpaRepository<EmpBench, Integer>{

	@Query("from EmpBench u where u.emp=?1")
	public List<EmpBench> getTasks(Employee emp);
	
	@Transactional
	@Modifying
	@Query("update EmpBench u set u.empStatus=?1 where u.emp=?2")
	public int updateStatus(String status, Employee emp);
	
	@Query("from EmpBench u where u.emp=?1")
	public EmpBench findBenchRecord(Employee emp);
	
	
	
}