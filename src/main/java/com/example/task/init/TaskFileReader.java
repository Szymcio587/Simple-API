package com.example.task.init;

import com.example.task.init.validate.TaskValidator;
import com.example.task.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskFileReader {

    @Autowired
    private TaskValidator taskValidator;

    public List<Task> ReadTasksFromFile(String filePath) throws IOException {
        List<Task> tasks = new ArrayList<>();
        ClassPathResource resource = new ClassPathResource(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");

            Task task = new Task();
            task.setName(fields[0]);
            task.setDeadline(LocalDate.parse(fields[1])); //parse already validates whether given string has proper format
            task.setDescription(fields[2]);
            taskValidator.ValidateTask(task);
            tasks.add(task);
        }

        reader.close();
        return tasks;
    }
}

