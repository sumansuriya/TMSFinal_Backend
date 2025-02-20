package com.cg.TMS.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.TMS.entity.EmpRequest;
import com.cg.TMS.services.AdminTaskApprovalService;

@Repository
public interface IAdminTaskApprovalRepository extends JpaRepository<EmpRequest, Integer> {

	

}
