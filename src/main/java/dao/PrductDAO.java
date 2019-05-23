package main.java.dao;

import main.java.entity.Product;

import java.util.List;

public interface PrductDAO {
    void add(Product product);
    List<Product> getAll();
    Product getAllById(Long id);
    void update(Product product);
    void remove(Product product);
}
