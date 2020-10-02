package service;

import model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService extends GnericServise <Product,Long> {

    Product create(Product product);

    Optional<Product> get(Long id);

    List<Product> getAll();

    Product update(Product product);

    boolean delete(Long id);
}
