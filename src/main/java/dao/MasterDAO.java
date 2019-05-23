package main.java.dao;

import main.java.entity.Master;

import java.util.List;

public interface MasterDAO {
    void add(Master master);
    List<Master> getAll();
    Master getAllById(Long id,Long klientId,Long masterId,Long productId);
    void update(Master master);
    void remove(Master master);
}
