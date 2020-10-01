package model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long orderId;
    private List<Product> products;
    private User user;
    private  LocalDateTime orderDate;
    private static Long generateId = 0L;

    public Order() {
        generateId = generateId + 1;
        this.orderId = generateId;
    }

    public Order(Long orderId, List<Product> products, User user, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.products = products;
        this.user = user;
        this.orderDate = orderDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
