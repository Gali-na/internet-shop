import Storage.StorageOrder;
import Storage.StorageProduct;
import Storage.StorageShoppingCart;
import Storage.StorageUser;
import daoImpl.DaoShoppingCartImpl;
import lib.Injector;
import model.Order;
import model.Product;
import model.ShoppingCart;
import model.User;
import service.OrderService;
import service.ProductService;
import service.ShoppingCartService;
import service.UserService;
import serviseImpl.OrderServiceImpl;
import serviseImpl.ProductServiceImpl;
import serviseImpl.ShoppingCartServiceImpl;
import serviseImpl.UserServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ShoppingCartServiceImpl shoppingCartnew = ( ShoppingCartServiceImpl) Injector.getInstance( ShoppingCartServiceImpl.class);

        ProductServiceImpl productnew = (ProductServiceImpl) Injector.getInstance(ProductServiceImpl.class);

        UserServiceImpl userServiceImplnew = (UserServiceImpl) Injector.getInstance(UserServiceImpl.class);

        OrderServiceImpl orderNew = (OrderServiceImpl) Injector.getInstance(OrderServiceImpl.class);


        Product phoneSamsung = new Product();
        phoneSamsung.setName("Samsung A510");
        phoneSamsung.setPrice(60);
        Product phoneApple = new Product();
        phoneApple.setName("X10");
        phoneApple.setPrice(100);
        Product phoneHuavay = new Product();
        phoneHuavay.setPrice(80);
        phoneHuavay.setName("XP450");

        productnew.create(phoneSamsung);
        productnew.create(phoneApple);
        productnew.create(phoneHuavay);
      //  System.out.println(StorageProduct.products);

     //   System.out.println( productnew.get(1L));
        phoneSamsung.setPrice(8000);
        productnew.update(phoneSamsung);
      //  System.out.println(productnew.getAll());

        User userOne= new User();
        User userTwo= new User();
        userOne.setPassword("123324");
        userOne.setName("Anna");
        userTwo.setName("Nika");
        userTwo.setPassword("242423");

        userServiceImplnew.create(userOne);
        userServiceImplnew.create(userTwo);
        System.out.println(StorageUser.users);
        userServiceImplnew.update(userOne);
        userOne.setName("Inna");
        System.out.println(userServiceImplnew.getAll());
        System.out.println(userServiceImplnew.get(1L));



        //ShoppingCartService shoppingCart = new ShoppingCartServiceImpl();
        List<Product> products = new ArrayList<>();
        products.add(phoneSamsung);
        products.add(phoneApple);
        products.add(phoneHuavay);
        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCart1.setProducts(products);
        shoppingCart1.setUser(userOne);
        shoppingCartnew.create(shoppingCart1);

        Order order = new Order(shoppingCart1.getBucketId(),
                shoppingCart1.getProducts(),
                shoppingCart1.getUser(), LocalDateTime.now());
        order.setUser(userTwo);
        orderNew.create(order);
        System.out.println();
        System.out.println();
        System.out.println(StorageOrder.orders);
        orderNew.update(order);
        System.out.println();
        System.out.println();
        System.out.println(orderNew.getAll());

    }
}
