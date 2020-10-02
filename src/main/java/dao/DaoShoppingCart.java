package dao;

import model.Product;
import model.ShoppingCart;

public interface DaoShoppingCart  extends  GenericDao <ShoppingCart,Long>{
    ShoppingCart addProduct(ShoppingCart shoppingCart, Product product);

    boolean deleteProduct(ShoppingCart shoppingCart, Product product);

    void clear(ShoppingCart shoppingCart);




}



