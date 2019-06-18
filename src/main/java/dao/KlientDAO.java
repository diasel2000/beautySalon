package main.java.dao;

import main.java.entity.Klient;

import java.util.List;

public interface KlientDAO {
    void add(Klient klient);
    List<Klient> getAll();
    Klient getById(Long id);
    void update(Klient klient);
    void remove(Klient klient);
}
