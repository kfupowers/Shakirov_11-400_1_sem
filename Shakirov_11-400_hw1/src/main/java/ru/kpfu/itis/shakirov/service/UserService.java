package ru.kpfu.itis.shakirov.service;

import ru.kpfu.itis.shakirov.dto.UserDto;
import ru.kpfu.itis.shakirov.entity.User;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();
    boolean signUp(String login, String password, String name, String surname, String path);
    boolean getByLoginAndPassword(String login, String password);
    User getByLogin(String login);
}
