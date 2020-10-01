package daoImpl;

import Storage.StorageShoppingCart;
import dao.DaoShoppingCart;
import model.Product;
import model.ShoppingCart;
import model.User;

import java.util.ArrayList;
import java.util.Optional;

public class DaoShoppingCartImpl implements DaoShoppingCart {


    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        if (StorageShoppingCart.shoppingCarts.add(shoppingCart)) {
            return shoppingCart;
        }
        return null;
    }

    @Override
    public ShoppingCart addProduct(ShoppingCart shoppingCart, Product product) {

        Optional<ShoppingCart> shoppingCartTemp = StorageShoppingCart.shoppingCarts.stream()
                .filter(cart-> cart.getBucketId().equals(shoppingCart.getBucketId()))
                .findFirst();
        if(shoppingCartTemp.isPresent()) {
          ArrayList <Product> productsfForCurrentshoppingCart= (ArrayList<Product>) shoppingCart.getProducts();
            productsfForCurrentshoppingCart.add(product);
            shoppingCart.setProducts(productsfForCurrentshoppingCart);
            return shoppingCart;
        }
       return null;
    }

    @Override
    public boolean deleteProduct(ShoppingCart shoppingCart, Product product) {
      Product productForRemove = (Product) shoppingCart.getProducts().stream()
                .filter(x->x.getId().equals(product.getId()))
                .map(x->shoppingCart.getProducts().remove(x));
       if(productForRemove!=null) {
           return true;
       }return false;
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {

        shoppingCart.getProducts().clear();
    }

    @Override
    public ShoppingCart getByUserId(Long userId) {
       Optional<ShoppingCart> shoppingCart = StorageShoppingCart.shoppingCarts.stream().
                filter(cart->cart.getUser().getUserId().equals(userId))
                .findFirst();
       if(shoppingCart.isPresent()) {
          return shoppingCart.get();
       }
        return null;
    }
    @Override
    public boolean deleteShoppingCart(Long idShoppingCart) {
    Optional<ShoppingCart> shoppingCart = StorageShoppingCart.shoppingCarts.stream()
                .filter(cart-> cart.getBucketId().equals(idShoppingCart))
                .findFirst();
        if(shoppingCart.isPresent()) {
            return StorageShoppingCart.shoppingCarts.remove(shoppingCart);
        }
       return false;
    }
}
