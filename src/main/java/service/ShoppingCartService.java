package service;

import model.Product;
import model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService extends GnericServise<ShoppingCart,Long>  {

    ShoppingCart addProduct(ShoppingCart shoppingCart, Product product);

    boolean deleteProduct(ShoppingCart shoppingCart, Product product);

    void clear(ShoppingCart shoppingCart);

}








