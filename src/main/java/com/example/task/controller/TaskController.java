package com.example.task.controller;

import com.example.task.init.validate.TaskValidator;
import com.example.task.model.Task;
import com.example.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskValidator taskValidator;

    @GetMapping("/tasks")
    public List<Task> AllTasks() {
        return this.taskService.GetAllTasks();
    }

    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> AddTask(@RequestBody Task task) {
        taskValidator.ValidateTask(task);
        this.taskService.AddTask(task);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Data has been added successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> DeleteTask(@PathVariable("id") Long id) {
        this.taskService.DeleteTask(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Data has been deleted successfully");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, String>> UpdateTask(@RequestBody Task task) {
        taskValidator.ValidateTask(task);
        this.taskService.UpdateTask(task);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Data has been updated successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/requests")
    public int GetRequestsNumber() {
        return this.taskService.GetRequestCount();
    }
}
