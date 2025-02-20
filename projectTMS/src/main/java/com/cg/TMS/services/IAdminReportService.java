package com.cg.TMS.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.EmpReport;

@Service
public interface IAdminReportService {

	public List<EmpReport> getAllReports();

	public EmpReport findReportById(int id);
	
}
