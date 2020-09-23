package model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private List<Product> products;
    private Long userId;
    private  LocalDateTime orderDate;

    public Order() {

    }
    public Order(Long id, List<Product> products, Long userId, LocalDateTime orderDate) {
        this.id = id;
        this.products = products;
        this.userId = userId;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
