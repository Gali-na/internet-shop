package daoImpl;

import Storage.StorageOrder;
import dao.DaoOrder;
import lib.DaoInjectOrder;
import model.Order;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DaoInjectOrder
public class DaoOrderImpl implements DaoOrder {
   /* @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order =new Order();
        order.setProducts(shoppingCart.getProducts());
        order.setUser(shoppingCart.getUser());
        order.setOrderDate(LocalDateTime.now());
       if (StorageOrder.orders.add(order)) {

           StorageShoppingCart.shoppingCarts.remove(shoppingCart);
           return order;
       }
        return null;
    }*/

    @Override
    public Order create(Order order) {
        if(StorageOrder.orders.add(order) == true) {
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
    public Optional<Order> get(Long id) {
      Optional<Order> orderUser= StorageOrder.orders.stream()
                .filter(order -> order.getOrderId().equals(id))
                .findFirst();
      if(orderUser.isPresent()) {
          //return orderUser.get();
      }
        return null;
    }

    @Override
    public Order update(Order order) {
       Optional<Integer> namberOrderForReplace = StorageOrder.orders.stream()
                .filter(orderInStream -> orderInStream.getOrderId().equals(order.getOrderId()))
                .map(orderForReplace -> StorageOrder.orders.indexOf(orderForReplace))
               .findFirst();
       if (namberOrderForReplace.isPresent()) {
           StorageOrder.orders.set(namberOrderForReplace.get(),order);
           return order;
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
