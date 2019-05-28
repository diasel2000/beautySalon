package main.java.dao;

import main.java.entity.Jurnal;

import java.sql.SQLException;
import java.util.List;

public interface JurnalDAO {
    void add(Jurnal jurnal) throws SQLException;
    List<Jurnal> getAll() throws SQLException;
    Jurnal getAllById(Long id,Long klientId,Long masterId,Long productId) throws SQLException;
    void update(Jurnal jurnal) throws SQLException;
    void remove(Jurnal jurnal) throws SQLException;
}
