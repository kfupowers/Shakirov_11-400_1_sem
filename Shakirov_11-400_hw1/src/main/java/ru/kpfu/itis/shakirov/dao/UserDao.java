package ru.kpfu.itis.shakirov.dao;

import ru.kpfu.itis.shakirov.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> getAll();

    boolean save(User user) throws SQLException;

    User getById(Integer id);

    boolean getByLoginAndPassword(String login, String password);

    boolean getByLogin(String login);
}
