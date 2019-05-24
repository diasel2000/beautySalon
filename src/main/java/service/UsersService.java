package main.java.service;

import db.DataBaseConection;
import main.java.dao.UsersDAO;
import main.java.entity.Users;

import java.util.List;

public class UsersService extends DataBaseConection implements UsersDAO {
    @Override
    public void add(Users users) {

    }

    @Override
    public List<Users> getAll() {
        return null;
    }

    @Override
    public Users getAllById(Long id) {
        return null;
    }

    @Override
    public void update(Users users) {

    }

    @Override
    public void remove(Users users) {

    }
}
