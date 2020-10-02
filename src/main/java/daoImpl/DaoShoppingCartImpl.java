package daoImpl;

import Storage.StorageProduct;
import Storage.StorageShoppingCart;
import dao.DaoShoppingCart;
import lib.DaoInjectShoppingCart;
import model.Product;
import model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DaoInjectShoppingCart
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
    public Optional<ShoppingCart> get(Long userId) {
        return   StorageShoppingCart.shoppingCarts.stream().
                filter(cart->cart.getUser().getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
      Optional <Integer> namberShopingCartForAbdate= StorageShoppingCart.shoppingCarts.stream()
              .filter(shoppingCartForUpdate-> shoppingCartForUpdate.getBucketId().equals(shoppingCart.getBucketId()))
              .map(shoppingCartForUpdate-> StorageShoppingCart.shoppingCarts.indexOf(shoppingCartForUpdate))
              .findFirst();
       if( namberShopingCartForAbdate.isPresent()) {
           StorageShoppingCart.shoppingCarts.set(namberShopingCartForAbdate.get(),shoppingCart);
           return shoppingCart;
       }
        return null;
    }

    @Override
    public boolean delete(Long idShoppingCart) {
    Optional<ShoppingCart> shoppingCart = StorageShoppingCart.shoppingCarts.stream()
                .filter(cart-> cart.getBucketId().equals(idShoppingCart))
                .findFirst();
        if(shoppingCart.isPresent()) {
            return StorageShoppingCart.shoppingCarts.remove(shoppingCart);
        }
       return false;
    }

    @Override
    public List<ShoppingCart> getAll() {

        return StorageShoppingCart.shoppingCarts;
    }
}
