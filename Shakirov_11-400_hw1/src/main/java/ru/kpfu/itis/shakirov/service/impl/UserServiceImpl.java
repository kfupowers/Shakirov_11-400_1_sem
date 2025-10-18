package ru.kpfu.itis.shakirov.service.impl;

import ru.kpfu.itis.shakirov.dao.UserDao;
import ru.kpfu.itis.shakirov.dao.impl.UserDaoImpl;
import ru.kpfu.itis.shakirov.dto.UserDto;
import ru.kpfu.itis.shakirov.entity.User;
import ru.kpfu.itis.shakirov.service.UserService;
import ru.kpfu.itis.shakirov.util.DatabaseConnectionUtil;
import ru.kpfu.itis.shakirov.util.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public List<UserDto> getAll() {
        return userDao.getAll().stream().map(
                u -> new UserDto(u.getName(), u.getLogin())
        ).toList();
    }

    @Override
    public boolean signUp(String login, String password, String name, String lastname) {
        try {
            return userDao.save(new User(null, name, lastname, login, PasswordUtil.encrypt(password)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean getByLoginAndPassword(String login, String password){
        return userDao.getByLoginAndPassword(login, PasswordUtil.encrypt(password));
    }

    @Override
    public boolean getByLogin(String login) {
        return userDao.getByLogin(login);
    }

}
