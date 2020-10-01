package dao;

import model.Product;
import model.ShoppingCart;

public interface DaoShoppingCart {
    ShoppingCart create(ShoppingCart shoppingCart);

    ShoppingCart addProduct(ShoppingCart shoppingCart, Product product);

    boolean deleteProduct(ShoppingCart shoppingCart, Product product);

    void clear(ShoppingCart shoppingCart);

    ShoppingCart getByUserId(Long userId);

    boolean deleteShoppingCart(Long id);
}



