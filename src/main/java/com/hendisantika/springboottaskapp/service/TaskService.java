package com.hendisantika.springboottaskapp.service;

import com.hendisantika.springboottaskapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
