package com.todo.services;

import com.todo.entity.Task;
import com.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAllTasks();
    }

    public Task getTaskById(Integer taskId){
        return taskRepository.findTaskById(taskId);
    }

    public Task createTask(Task task){
        return taskRepository.saveTask(task);
    }

    public Task updateTask(Integer taskId, Task updatedTask){
        Task existingTask = taskRepository.findTaskById(taskId);
        if(existingTask == null){
            return null;
        }

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setCompleted(updatedTask.isCompleted());

        return taskRepository.updateTask(existingTask);
    }

    public  void deleteTask(Integer taskId){
        taskRepository.deleteTask(taskId);
    }

}
