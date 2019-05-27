package main.java.dao;

import main.java.entity.Users;

import java.sql.SQLException;
import java.util.List;

public interface UsersDAO {
    String add(Users users) throws SQLException;
    String getUser(Users users);
    Users getAllById(Long id);
    void update(Users users);
    void remove(Users users);
}
