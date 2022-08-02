package org.sgi.project.entity;

public class Person {

    Long id;
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public Person setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Person setPassword(String password) {
        this.password = password;
        return this;
    }

}
