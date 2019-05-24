package main.java.dao;

import main.java.entity.Master;
import main.java.entity.Salon;

import java.sql.SQLException;
import java.util.List;

public interface SalonDAO {
    void add(Salon salon) throws SQLException;
    List<Salon> getAll() throws SQLException;
    Salon getAllById(Long id,Long jurnalId) throws SQLException;
    void update(Salon salon) throws SQLException;
    void remove(Salon salon) throws SQLException;
}
