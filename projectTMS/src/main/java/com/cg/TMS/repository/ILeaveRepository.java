package com.cg.TMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.Leave;
import com.cg.TMS.entity.Task;
	
@Repository
public interface ILeaveRepository extends JpaRepository <Leave, Integer>{
	
	@Query("from Leave u where u.tasks=?1")
	public List<Leave> leavesRecord(Task tasks);
	
	@Transactional
	@Modifying
	@Query("delete from Leave u where u.tasks=?1")
	public void deleteLeavebyTaskId(Task tasks);
		
}

