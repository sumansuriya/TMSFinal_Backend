package com.cg.TMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.TMS.entity.EmpBench;
import com.cg.TMS.entity.EmpTaskAssign;
import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.Task;

@Repository
public interface IEmpTaskAssignedRepository extends JpaRepository<EmpTaskAssign, Integer>{

	@Query("from EmpTaskAssign u where u.taslist=?1")
	public EmpTaskAssign findEmpTaskRecord(Task taslist);
	
	@Transactional
	@Modifying
	@Query("delete from EmpTaskAssign u where u.empl=?1")
	public void deleteTaskRecordsbyEmpId(Employee empl);
	
}
