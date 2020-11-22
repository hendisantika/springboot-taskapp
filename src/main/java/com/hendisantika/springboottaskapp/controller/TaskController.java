package com.hendisantika.springboottaskapp.controller;

import com.hendisantika.springboottaskapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
public class TaskController {

    @Autowired
    private TaskService taskService;

}
