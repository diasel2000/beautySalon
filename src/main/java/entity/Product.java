package main.java.entity;

import java.util.Objects;

public class Product {
    private Long id;
    private String productName;
    private Float price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass () != o.getClass ()) return false;
        Product product = (Product) o;
        return Objects.equals ( id, product.id ) &&
                Objects.equals ( productName, product.productName ) &&
                Objects.equals ( price, product.price );
    }

    @Override
    public int hashCode() {

        return Objects.hash ( id, productName, price );
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }
}
