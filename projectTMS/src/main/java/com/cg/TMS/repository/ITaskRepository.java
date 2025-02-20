package com.cg.TMS.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.Task;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Integer> {

	@Query("from Task u where u.emp=?1")
	public List<Task> getTsks(Employee emp);
	
	@Transactional
	@Modifying
	@Query("delete from Task u where u.emp=?1")
	public void deleteTasksbyEmpId(Employee emp);
	
}
