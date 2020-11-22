package com.hendisantika.springboottaskapp.controller;

import com.hendisantika.springboottaskapp.model.Status;
import com.hendisantika.springboottaskapp.model.Task;
import com.hendisantika.springboottaskapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-taskapp
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/20
 * Time: 05.50
 */
@Controller
@RequestMapping(value = {"/tasks", "/"})
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * GET all tasks from Database
     *
     * @return template view for all tasks
     */
    @GetMapping
    public String dashboard(Model model) {
        //display all Tasks
        Set<Task> tasks = taskService.getTasks();
        model.addAttribute("tasks", tasks);

        Set<Status> statusList = new HashSet<>();
        Status.stream().forEach(statusList::add);
        model.addAttribute("statusList", statusList);

        return "index";
    }

    /**
     * Shows Tasks by Status
     *
     * @param model      contains TaskObject
     * @param taskStatus may have the values "open/closed/reopened"
     * @return Set of Tasks with specific status
     */
    @GetMapping(value = "/{status}")
    public String displayByStatus(Model model, @PathVariable("status") String taskStatus) {
        if (taskStatus.equals(Status.OPEN.getTypeOfStatus())) {
            model.addAttribute("tasks", taskService.getTasksByStatus(Status.OPEN));
        } else if (taskStatus.equals(Status.CLOSED.getTypeOfStatus())) {
            model.addAttribute("tasks", taskService.getTasksByStatus(Status.CLOSED));
        } else if (taskStatus.equals(Status.REOPENED.getTypeOfStatus())) {
            model.addAttribute("tasks", taskService.getTasksByStatus(Status.REOPENED));
        }

        Set<Status> statusList = new HashSet<>();
        Status.stream().forEach(statusList::add);
        model.addAttribute("statusList", statusList);

        return "index";
    }
}
