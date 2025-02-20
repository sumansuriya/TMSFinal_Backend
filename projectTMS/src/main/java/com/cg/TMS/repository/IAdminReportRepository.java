package com.cg.TMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.TMS.entity.EmpReport;

@Repository
public interface IAdminReportRepository extends JpaRepository<EmpReport, Integer>{

}
