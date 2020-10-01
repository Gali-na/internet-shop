import Storage.StorageShoppingCart;
import dao.DaoProduct;
import dao.DaoShoppingCart;
import daoImpl.DaoProductImpl;
import daoImpl.DaoShoppingCartImpl;
import daoImpl.DaoUserImpl;
import model.Product;
import model.ShoppingCart;
import model.User;
import serviseImpl.ShoppingCartServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DaoShoppingCartImpl daoShoppingCart = new DaoShoppingCartImpl();
        ShoppingCart shoppingCart = new ShoppingCart();

        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setPrice(5);
        product1.setName("uuuu");

        Product product2 = new Product();
        product1.setPrice(2);
        product1.setName("llll");
    products.add(product1);
    products.add(product2);

    shoppingCart.setProducts(products);

    User user= new User();
    user.setName("fgr");
    user.setPassword("444");

    shoppingCart.setUser(user);

    DaoShoppingCartImpl daoShoppingCart1 = new DaoShoppingCartImpl();
    daoShoppingCart1.create(shoppingCart);
        daoShoppingCart1.addProduct(shoppingCart,product1);
        System.out.println(daoShoppingCart1.addProduct(shoppingCart,product1));
        System.out.println(daoShoppingCart1.deleteShoppingCart(1L));
        System.out.printf(StorageShoppingCart.shoppingCarts.toString()+" sgaha");
       // System.out.println(StorageShoppingCart.shoppingCarts);

    }
    }
