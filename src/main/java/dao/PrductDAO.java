package main.java.dao;

import main.java.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface PrductDAO {
    void add(Product product) throws SQLException;
    List<Product> getAll() throws SQLException;
    Product getAllById(Long id) throws SQLException;
    void update(Product product) throws SQLException;
    void remove(Product product) throws SQLException;
}
