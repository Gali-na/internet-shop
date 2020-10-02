package serviseImpl;

import Storage.StorageOrder;
import dao.DaoOrder;
import lib.Inject;
import model.Order;
import service.OrderService;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    @Inject
    private DaoOrder daoOrder;

    @Override
    public Order create(Order order) {
        if(order==null) {
            System.out.println("The order was created with an error, please re-create the order");
            return  null;
        }
        if(order.getOrderId()==0) {
            System.out.println("The order was created incorrectly, the ID was incorrectly specified");
            return  null;
        }
        if(order.getProducts().size()==0) {
            System.out.println("The order was created by mistake, the list " +
                    "of products is empty, please create the order again");
            return  null;
        }
        if(order.getUser()== null) {
            System.out.println("The order was created by mistake, the user is not specified");
            return  null;
        } else {
             StorageOrder.orders.add(order);
             return  order;
        }
    }

    @Override
    public Optional<Order> get(Long id) {
        return  StorageOrder.orders.stream()
                .filter(o->o.getOrderId().equals(id))
                .findFirst();
    }

    @Override
    public List<Order> getAll() {
        return StorageOrder.orders;
    }

    @Override
    public boolean delete(Long id) {
       Optional<Order> namberStorageOrder = StorageOrder.orders.stream()
                .filter(o->o.getOrderId().equals(id))
                .findFirst();
       if(namberStorageOrder.isPresent()) {
           StorageOrder.orders.remove(namberStorageOrder.get());
           return true;
       }
        return false;
    }

    @Override
    public Order update(Order order) {
        Optional<Integer> namberStorageOrder =  StorageOrder.orders.stream()
                .filter(o->o.getOrderId().equals(order.getOrderId()))
                .map(o->StorageOrder.orders.indexOf(order))
                .findFirst();
        if(namberStorageOrder.isPresent()) {
            StorageOrder.orders.set(namberStorageOrder.get(),order);
            return order;
        }
        return null;
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        return StorageOrder.orders;
    }
}
