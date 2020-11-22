package com.hendisantika.springboottaskapp.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-taskapp
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/20
 * Time: 05.41
 */
@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @NotEmpty
    private String title;

    @Lob
    @NotEmpty
    @Type(type = "org.hibernate.type.TextType") //heroku config
    private String content;

    //status may not be null
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Status status;

    public Task() {
        this.status = Status.OPEN;
    }

    public void closeTask() {
        this.status = Status.CLOSED;
    }

    public void reopenTask() {
        this.status = Status.REOPENED;
    }
}
