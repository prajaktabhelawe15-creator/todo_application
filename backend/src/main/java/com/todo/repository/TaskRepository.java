package com.todo.repository;

import com.todo.entity.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAllTasks();

    Task findTaskById(Integer taskId);

    Task saveTask(Task task);

    Task updateTask(Task task);

    void deleteTask(Integer taskId);
}
