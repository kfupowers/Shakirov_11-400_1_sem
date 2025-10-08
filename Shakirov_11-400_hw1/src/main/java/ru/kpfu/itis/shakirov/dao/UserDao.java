package com.solncev.dao;

import com.solncev.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> getAll();

    void save(User user) throws SQLException;

    User getById(Integer id);

}
