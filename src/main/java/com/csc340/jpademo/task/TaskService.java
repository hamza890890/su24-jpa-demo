package com.csc340.jpademo.task;

import com.csc340.jpademo.goal.Goal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public Object getAllTasks() {
        return taskRepository.findAll();
    }
    public Task getTaskById(int taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }
    public void updateTask(Task task) {
        Task newTask = getTaskById(task.getTaskId());
        if(!task.getTitle().isEmpty()){
            newTask.setTitle(task.getTitle());
        }
        if(!task.getStatus().isEmpty()){
            newTask.setStatus(task.getStatus());
        }
        if(!task.getDetails().isEmpty()){
            newTask.setDetails(task.getDetails());
        }
        taskRepository.save(newTask);

    }

    public void deleteTaskById(int taskId) {
        taskRepository.deleteById(taskId);
    }


    public void addNewTask(Task task) {
        taskRepository.save(task);
    }
}