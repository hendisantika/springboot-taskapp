package com.hendisantika.springboottaskapp.service;

import com.hendisantika.springboottaskapp.model.Task;
import com.hendisantika.springboottaskapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-taskapp
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/20
 * Time: 05.43
 */
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    /**
     * GET all tasks from DB
     *
     * @return all tasks from Database
     */
    public Set<Task> getTasks() {
        Set<Task> taskSet = new HashSet<>();
        taskRepository.findAll().iterator().forEachRemaining(taskSet::add);
        return taskSet;
    }

    /**
     * finds a task by its ID
     *
     * @param taskId Database ID of task
     * @return task
     */
    public Task findById(Long taskId) {
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if (!taskOptional.isPresent()) {
            throw new RuntimeException("Task Not Found!");
        }
        return taskOptional.get();
    }


    /**
     * creates new Task and saves it in Database
     *
     * @param taskDetails field values
     * @return new Task
     */
    public Task createTask(Task taskDetails) {
        return taskRepository.save(taskDetails);
    }

    /**
     * updates Task from Database with field values in taskDetails
     *
     * @param taskId      Database ID of task
     * @param taskDetails field values
     */
    public Task updateTask(Long taskId, Task taskDetails) {
        Task task = findById(taskId);
        task.setTitle(taskDetails.getTitle());
        task.setContent(taskDetails.getContent());
        task.setStatus(taskDetails.getStatus());
        taskRepository.save(task);
        return task;
    }
}
