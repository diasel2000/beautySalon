package main.java.dao;

import main.java.entity.Jurnal;

import java.util.List;

public interface JurnalDAO {
    void add(Jurnal jurnal);
    List<Jurnal> getAll();
    Jurnal getAllById(Long id,Long klientId,Long masterId,Long productId);
    void update(Jurnal jurnal);
    void remove(Jurnal jurnal);
}
