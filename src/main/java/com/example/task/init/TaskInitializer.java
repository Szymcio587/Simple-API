package com.example.task.init;

import com.example.task.model.Task;
import com.example.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskInitializer implements CommandLineRunner {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskFileReader taskFileReader;

    @Override
    public void run(String... args) throws Exception {
        String filePath = "static/simple_data.txt";
        List<Task> tasks = taskFileReader.ReadTasksFromFile(filePath);
        for(Task task : tasks)
            taskService.AddTask(task);
    }
}