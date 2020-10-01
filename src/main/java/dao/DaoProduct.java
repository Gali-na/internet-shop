package dao;

import model.Order;
import model.Product;

import java.util.List;
import java.util.Optional;

public interface DaoProduct {
     Product create(Product product);
     Optional<Product> getById(Long ProductId);
     Product update(Product product);
     boolean deleteById(Long productId);
     boolean delete(Product product);
     List<Product> getAllProduct();


}
