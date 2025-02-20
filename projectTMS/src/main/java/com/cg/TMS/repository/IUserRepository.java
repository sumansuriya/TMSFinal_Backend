package com.cg.TMS.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.Task;

@Repository
public interface IUserRepository extends JpaRepository<Employee, Integer> {
	
	@Query("from Employee e where e.empid=?1")
	public Employee getById(int id);
	
	@Query("from Employee u where u.username=?1 and u.password=?2")
	public Employee findByUsernamePassword(String username, String password);



}






