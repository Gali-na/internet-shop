package dao;

import model.Order;
import model.ShoppingCart;

import java.util.List;

public interface DaoOrder {

    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getUserOrders(Long userId);

    Order get(Long id);

    List<Order> getAll();

    boolean delete(Long id);
}
