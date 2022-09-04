/**
 * 
 */
package com.avinash.ProjManager.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.context.ApplicationStartupAware;
import org.springframework.stereotype.Service;

import com.avinash.ProjManager.model.Task;
import com.avinash.ProjManager.model.User;
import com.avinash.ProjManager.repository.TaskRepository;
import com.avinash.ProjManager.service.TaskService;

/**
 * @author avinash
 *
 */

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public void createTask(Task task) {
		taskRepository.save(task);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void updateTask(Long id, Task updateTask) {
		Task task = taskRepository.getOne(id);
		task.setName(updateTask.getName());
		task.setDescription(updateTask.getDescription());
		task.setDate(updateTask.getDate());
		taskRepository.save(task);
		
	}

	@Override
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
		
	}

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public List<Task> findByOwnerOrderByDateDesc(User user) {
		return taskRepository.findByOwnerOrderByDateDesc(user);
	}

	@Override
	public void setTaskCompleted(Long id) {
		Task task = taskRepository.getOne(id);
		task.setCompleted(true);
		taskRepository.save(task);
		
		
	}

	@Override
	public void setTaskNotCompleted(Long id) {
		Task task = taskRepository.getOne(id);
		task.setCompleted(false);
		taskRepository.save(task);
		
	}

	@Override
	public List<Task> findFreeTasks() {
		return taskRepository.findAll()
				.stream()
                .filter(task -> task.getOwner() == null && !task.isCompleted())
                .collect(Collectors.toList());
	}

	@Override
	public Task getTaskById(Long taskId) {
		return taskRepository.findById(taskId).orElse(null);
	}

	@Override
	public void assignTaskToUser(Task task, User user) {
		task.setOwner(user);
		taskRepository.save(task);
		
	}

	@Override
	public void unassignTask(Task task) {
		task.setOwner(null);
		taskRepository.save(task);
	}

}
