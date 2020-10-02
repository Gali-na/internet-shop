package service;

import model.Order;
import model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface OrderService extends GnericServise <Order,Long> {

    List<Order> getUserOrders(Long userId);
}
