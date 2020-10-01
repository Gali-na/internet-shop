package model;

import java.util.List;

public class ShoppingCart {
    private static Long generateId = 0L;
    private Long bucketId;
    private List<Product> products;
    private User user;

    public ShoppingCart() {
        generateId = generateId + 1;
        this.bucketId = generateId;
    }

    public Long getBucketId() {

        return bucketId;
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

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "bucketId=" + bucketId +
                ", products=" + products +
                ", user=" + user +
                '}';
    }
}
