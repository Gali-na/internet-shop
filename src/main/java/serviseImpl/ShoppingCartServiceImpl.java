package serviseImpl;

import Storage.StorageShoppingCart;
import dao.DaoShoppingCart;
import lib.Inject;
import model.Product;
import model.ShoppingCart;
import service.ShoppingCartService;

import java.util.List;
import java.util.Optional;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Inject
    private DaoShoppingCart daoShoppingCart;

    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        if (shoppingCart.getUser() == null) {
            System.out.println("To register an order, you must enter user data");
            return null;
        }
        if (shoppingCart.getProducts().size() == 0) {
            System.out.println("The list of products you have selected is empty, please try to select the products again.");
            return null;
        }
        if (shoppingCart.getBucketId() == 0) {
            System.out.println("The order ID was entered incorrectly, please try again");
            return null;
        }
        Optional<ShoppingCart> cartCheckeId = StorageShoppingCart.shoppingCarts.stream()
                .filter(cart -> cart.getBucketId().equals(shoppingCart.getBucketId()))
                .findFirst();
        if (cartCheckeId.isPresent()) {
            System.out.println("The order ID was entered incorrectly, please try again");
            return null;
        } else {
            return daoShoppingCart.create(shoppingCart);
        }

    }

    @Override
    public ShoppingCart addProduct(ShoppingCart shoppingCart, Product product) {

        if (daoShoppingCart.addProduct(shoppingCart, product) == null) {
            System.out.println("The card or product data entered is not correct, please try again.");
            return null;
        } else {
            return daoShoppingCart.addProduct(shoppingCart, product);
        }
    }

    @Override
    public boolean deleteProduct(ShoppingCart shoppingCart, Product product) {
        if (daoShoppingCart.deleteProduct(shoppingCart, product) == false) {
            System.out.println("Unable to uninstall the product, please try again");
        }
        return daoShoppingCart.deleteProduct(shoppingCart, product);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        daoShoppingCart.clear(shoppingCart);

    }

    @Override
    public Optional<ShoppingCart> get(Long userId) {
        if (daoShoppingCart.get(userId) == null) {
            System.out.println("No shopping cart found for the specified ID");
            return null;
        }
        return daoShoppingCart.get(userId);
    }

    @Override
    public List<ShoppingCart> getAll() {
        return StorageShoppingCart.shoppingCarts;
    }

    @Override
    public ShoppingCart update(ShoppingCart element) {
       if( daoShoppingCart.update(element)!=null) {
           return daoShoppingCart.update(element);
       }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (daoShoppingCart.delete(id) == false) {
            System.out.println("Failed to empty trash");
        }
        return daoShoppingCart.delete(id);
    }
}
