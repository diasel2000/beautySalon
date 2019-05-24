package main.java.dao;

import main.java.entity.Klient;

import java.sql.SQLException;
import java.util.List;

public interface KlientDAO {
    void add(Klient klient) throws SQLException;
    List<Klient> getAll() throws SQLException;
    Klient getById(Long id) throws SQLException;
    void update(Klient klient) throws SQLException;
    void remove(Klient klient) throws SQLException;
}
