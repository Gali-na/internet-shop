package daoImpl;

import Storage.StorageShoppingCart;
import dao.DaoShoppingCart;
import model.ShoppingCart;

public class DaoShoppingCartImpl implements DaoShoppingCart {

    @Override
    public void add(ShoppingCart shopingCart) {
        StorageShoppingCart.shoppingCarts.add(shopingCart);

    }
}
