package com.example.task;

import com.example.task.model.Task;
import com.example.task.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ConnectionTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void SaveTask() {
        Task task = new Task("TaskExample", LocalDate.now(), "TaskDescription");
        this.taskRepository.save(task);
        Task retrievedTask = this.taskRepository.findById(1L).get(); //no need to check egde cases in tests, like empty optional itp.
        assertNotNull(retrievedTask.getName());
        assertEquals(retrievedTask.getName(), task.getName());
    }

    @Test
    public void UpdateTask() {
        Task task = new Task("TaskExample", LocalDate.now(), "TaskDescription");
        this.taskRepository.save(task);
        String newName = "ExampleOfTask";
        Task toUpdate = this.taskRepository.findById(1L).get();
        toUpdate.setName(newName);
        this.taskRepository.save(toUpdate);
        Task retrievedTask = this.taskRepository.findById(1L).get();
        assertNotNull(retrievedTask.getName());
        assertEquals(retrievedTask.getName(), newName);
    }

}
