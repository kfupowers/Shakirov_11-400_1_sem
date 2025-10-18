package ru.kpfu.itis.shakirov.service;

import ru.kpfu.itis.shakirov.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();
    boolean signUp(String login, String password, String name, String surname);
    boolean getByLoginAndPassword(String login, String password);
    boolean getByLogin(String login);
}
