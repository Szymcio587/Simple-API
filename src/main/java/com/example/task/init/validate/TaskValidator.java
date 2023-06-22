package com.example.task.init.validate;

import com.example.task.model.Task;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TaskValidator {

    private String message;

    public void ValidateTask(Task task) {
        if (task.getName().isEmpty() || task.getDeadline() == null) {
            message = "Data for task nr. " + task.getId() + " is incomplete";
            throw new RuntimeException(message);
        }
        ValidateName(task.getName(), task.getId());
        ValidateDescription(task.getDescription(), task.getId());
    }

    public static boolean StringValidation(String input) {
        String pattern = "^[a-zA-Z0-9.,;'\"() ]+$";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        return matcher.matches();
    }

    public void ValidateName(String name, Long id) {
        if(!StringValidation(name)) {
            message = "Task nr. " + id + " has wrong name format";
            throw new RuntimeException(message);
        }
    }

    public void ValidateDescription(String description, Long id) {
        if(!StringValidation(description)) {
            message = "Task nr. " + id + " has wrong name format";
            throw new RuntimeException(message);
        }
    }

}
