package com.cg.TMS.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.TMS.entity.Employee;
import com.cg.TMS.entity.EmpReport;
import com.cg.TMS.entity.Task;

@Service
public interface IEmpReportService {

	public List<Task> getAllTasksByEmpId(int id);
}
