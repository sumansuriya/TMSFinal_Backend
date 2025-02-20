package com.cg.TMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.TMS.entity.EmpRequest;
import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.Task;


@Repository
public interface IEmpRequestRepository extends JpaRepository<EmpRequest, Integer> {
	
@Query("from EmpRequest u where u.task=?1")
public	List<EmpRequest> findAllByTaskId(Task task);

@Transactional
@Modifying
@Query("delete from EmpRequest u where u.task=?1")
public void deleteRequestbyTaskId(Task task);

}
