package com.cg.TMS.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.TMS.entity.Task;

@Service
public interface IEmpTaskAssignedService {

	public List<Task> FindTasksByEmpId(int id);
}
