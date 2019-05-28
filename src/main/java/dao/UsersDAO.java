package main.java.dao;

import main.java.entity.Users;

import java.util.List;

public interface UsersDAO {
    void add(Users users);
    List<Users> getAll();
    Users getAllById(Long id);
    void update(Users users);
    void remove(Users users);
}
