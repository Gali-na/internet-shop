package serviseImpl;

import Storage.StorageShoppingCart;
import dao.DaoShoppingCart;
import daoImpl.DaoShoppingCartImpl;
import service.ShoppingCartService;
import model.Product;
import model.ShoppingCart;

import java.util.Optional;

public class ShoppingCartServiceImpl implements ShoppingCartService {

  DaoShoppingCart daoShoppingCart =new DaoShoppingCartImpl();

    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        if(shoppingCart.getUser()==null) {
            System.out.println("To register an order, you must enter user data");
            return null;
        }
        if(shoppingCart.getProducts().size()==0) {
            System.out.println("The list of products you have selected is empty, please try to select the products again.");
            return null;
        }
        if(shoppingCart.getBucketId()==0) {
            System.out.println("The order ID was entered incorrectly, please try again");
            return null;
        }
       Optional <ShoppingCart> cartCheckeId= StorageShoppingCart.shoppingCarts.stream()
                .filter(cart-> cart.getBucketId().equals(shoppingCart.getBucketId()))
                .findFirst();
        if(cartCheckeId.isPresent()) {
            System.out.println("The order ID was entered incorrectly, please try again");
            return null;
        }
        else {
            return  daoShoppingCart.create(shoppingCart);
        }

    }

    @Override
    public ShoppingCart addProduct(ShoppingCart shoppingCart, Product product) {
        if( daoShoppingCart.addProduct(shoppingCart, product)==null) {
            System.out.println("The card or product data entered is not correct, please try again.");
        return null;
        }else {
            return shoppingCart;
        }
    }

    @Override
    public boolean deleteProduct(ShoppingCart shoppingCart, Product product) {
     if(daoShoppingCart.deleteProduct(shoppingCart, product)==false) {
         System.out.println("Unable to uninstall the product, please try again");
     }
     return daoShoppingCart.deleteProduct(shoppingCart, product);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        daoShoppingCart.clear(shoppingCart);

    }

    @Override
    public ShoppingCart getByUserId(Long userId) {
      if(daoShoppingCart.getByUserId(userId) ==null) {
          System.out.println("No shopping cart found for the specified ID");
          return null;
      }
        return daoShoppingCart.getByUserId(userId);
    }

    @Override
    public boolean delete(Long id) {
        if (daoShoppingCart.deleteShoppingCart(id) == false) {
            System.out.println("Failed to empty trash");
        }
        return daoShoppingCart.deleteShoppingCart(id);
    }
}
