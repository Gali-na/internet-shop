package dao;

import model.Order;

import java.util.List;

public interface DaoOrder extends GenericDao<Order, Long> {

    List<Order> getUserOrders(Long userId);
}











