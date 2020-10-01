package model;

public class Product {
    private static Long generateId = 0L;
    private Long id;
    private String name;
    private double price;

    public Product() {
        generateId = generateId + 1;
        this.id = generateId;
    }

    public Product(String name, double price) {
        this.id = generateId;
        this.name = name;
        this.price = price;
    }

    public Long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
