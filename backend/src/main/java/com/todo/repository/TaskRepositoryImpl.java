package com.todo.repository;

import com.todo.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.todo.repository.TaskRepositoryImpl;

import java.util.List;

@Repository
@Transactional
public class TaskRepositoryImpl implements  TaskRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Task> findAllTasks(){
        String query = "SELECT task FROM Task task";

        return entityManager.createQuery(query, Task.class).getResultList();
    }

    @Override
    public Task findTaskById(Integer taskId){
        return entityManager.find(Task.class, taskId);
    }

    @Override
    public Task saveTask(Task task){
        entityManager.persist(task);
        return task;
    }

    @Override
    public Task updateTask(Task task){
        return entityManager.merge(task);
    }

    @Override
    public void deleteTask(Integer taskId){
        Task task = findTaskById(taskId);

        if(task != null){
            entityManager.remove(task);
        }
    }
}
