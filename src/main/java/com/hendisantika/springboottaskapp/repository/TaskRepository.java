package com.hendisantika.springboottaskapp.repository;

import com.hendisantika.springboottaskapp.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-taskapp
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/20
 * Time: 05.42
 */
@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}