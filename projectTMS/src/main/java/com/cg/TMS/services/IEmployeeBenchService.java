package com.cg.TMS.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.TMS.entity.EmpBench;
import com.cg.TMS.entity.Task;
@Service
public interface IEmployeeBenchService {

public	EmpBench findEmpByProjectid(int id);
	
	public List<EmpBench> getAllEmps();

}
