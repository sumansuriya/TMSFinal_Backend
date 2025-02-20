package com.cg.TMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.TMS.entity.Admin;
import com.cg.TMS.entity.EmpBench;
import com.cg.TMS.entity.EmpReport;
import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.Task;

@Repository
public interface IEmpReportRepository extends JpaRepository<EmpReport, Integer>{

	@Query("from EmpReport u where u.taskList=?1")
	public EmpReport findEmpReportRecord(Task taskList);
	
	@Transactional
	@Modifying
	@Query("delete from EmpReport u where u.emp=?1")
	public void deleteReportsbyEmpId(Employee emp);

	
}
