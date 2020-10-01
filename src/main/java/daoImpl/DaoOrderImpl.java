package daoImpl;

import Storage.StorageOrder;
import dao.DaoOrder;
import dao.DaoShoppingCart;
import model.Order;
import model.ShoppingCart;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DaoOrderImpl implements DaoOrder {
    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order =new Order();
        order.setProducts(shoppingCart.getProducts());
        order.setUser(shoppingCart.getUser());
        order.setOrderDate(LocalDateTime.now());
       if (StorageOrder.orders.add(order)) {

           DaoShoppingCart dellShopingCart=  new DaoShoppingCartImpl ();
           dellShopingCart.deleteShoppingCart(shoppingCart.getBucketId());
           return order;
       }
        return null;
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return StorageOrder.orders.stream()
                .filter(order -> order.getUser().getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public Order get(Long id) {
      Optional<Order> orderUser= StorageOrder.orders.stream()
                .filter(order -> order.getOrderId().equals(id))
                .findFirst();
      if(orderUser.isPresent()) {
          return orderUser.get();
      }
        return null;
    }

    @Override
    public List<Order> getAll() {

        return  StorageOrder.orders;
    }

    @Override
    public boolean delete(Long idOrder) {
       Optional<Order> orderUser= StorageOrder.orders.stream()
                .filter(order-> order.getOrderId().equals(idOrder))
                .findFirst();
       if(orderUser.isPresent()) {
           return  StorageOrder.orders.remove(orderUser.get());

       }
        return false;
    }
}
