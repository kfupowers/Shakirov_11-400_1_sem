package ru.kpfu.itis.shakirov.entity;

public class User {

    private Integer id;
    private String name;
    private String lastname;
    private String login;
    private String password;
    private String path;

    public User() {}

    public User(Integer id, String name, String lastname, String login, String password, String path) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPath() {
        return path;
    }
}

