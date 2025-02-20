package com.cg.TMS.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cg.TMS.entity.Task;

@Service
public interface IAdminTaskService {

	public List<Task> getAllTasks();

	public Task saveTasks(Task task);

	public Task findTaskById(int id);

	public void updateTask(Task task);
//		public void updateTaskById(int id);

	public void deleteTaskById(int id);

}
