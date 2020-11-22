package com.hendisantika.springboottaskapp.model;

import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-taskapp
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/11/20
 * Time: 05.40
 */
public enum Status {
    OPEN("open"),
    CLOSED("closed"),
    REOPENED("reopened");

    private final String typeOfStatus;

    Status(String typeOfStatus) {
        this.typeOfStatus = typeOfStatus;
    }

    public static Stream<Status> stream() {
        return Stream.of(Status.values());
    }

    public String getTypeOfStatus() {
        return typeOfStatus;
    }
}
