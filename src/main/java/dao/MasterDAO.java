package main.java.dao;

import main.java.entity.Master;

import java.sql.SQLException;
import java.util.List;

public interface MasterDAO {
    void add(Master master) throws SQLException;
    List<Master> getAll() throws SQLException;
    Master getAllById(Long id) throws SQLException;
    void update(Master master) throws SQLException;
    void remove(Master master) throws SQLException;
}
