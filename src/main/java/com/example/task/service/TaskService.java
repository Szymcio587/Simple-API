package com.example.task.service;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public int requestsNumber = 0;

    public int GetRequestCount() {
        return requestsNumber;
    }

    public void AddTask(Task task) {
        requestsNumber++;
        this.taskRepository.save(task);
    }

    public List<Task> GetAllTasks() {
        List<Task> tasks = new ArrayList<>();
        this.taskRepository.findAll().forEach(tasks::add);
        requestsNumber++;
        return tasks;
    }

    public void DeleteTask(Long id) {
        requestsNumber++;
        this.taskRepository.deleteById(id);
    }

    public void UpdateTask(Task newTask) {
        requestsNumber++;
        Task task = this.taskRepository.findById(newTask.getId())
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));

        task.setName(newTask.getName());
        task.setDeadline(newTask.getDeadline());
        task.setDescription(newTask.getDescription());

        this.taskRepository.save(task);
    }
}
