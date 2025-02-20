package com.cg.TMS.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.EmpReport;
import com.cg.TMS.exception.UserNotFoundException;
import com.cg.TMS.repository.IAdminReportRepository;

@Service
public class AdminReportService implements IAdminReportService {

	@Autowired
	IAdminReportRepository report1;
	
	@Override
	public List<EmpReport> getAllReports() {
		// TODO Auto-generated method stub
		return report1.findAll();	
		}

	@Override
	public EmpReport findReportById(int id) {
		// TODO Auto-generated method stub
		Optional<EmpReport> userreport = report1.findById(id);

		if(userreport.isEmpty() || userreport == null) {
			throw new UserNotFoundException("Report Not Found For The Given ID : " +id);
		}
		return userreport.get();
	}

}
