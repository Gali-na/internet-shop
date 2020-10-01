package serviseImpl;

import Storage.StorageShoppingCart;
import dao.DaoOrder;
import daoImpl.DaoOrderImpl;
import service.OrderService;
import model.Order;
import model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    DaoOrder daoOrder = new DaoOrderImpl();

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {

        if(shoppingCart== null) {
            System.out.println("Your shopping cart is empty, unable to create an order,"
                   + "unable to create an order");
            return null;
        }
        if(shoppingCart.getProducts().size()==0) {
            System.out.println("The list of products you have selected is empty," +
                    " please try to select the products again, unable to create an order");
            return null;
        }
        if(shoppingCart.getBucketId()==0) {
            System.out.println("The order ID was entered incorrectly, please try again, unable to create an order");
            return null;
        }
        Optional<ShoppingCart> cartCheckeId= StorageShoppingCart.shoppingCarts.stream()
                .filter(cart-> cart.getBucketId().equals(shoppingCart.getBucketId()))
                .findFirst();
        if(cartCheckeId.isPresent()) {
            System.out.println("The order ID was entered incorrectly, please try again, unable to create an order");
            return null;
        } else {
            return  daoOrder.completeOrder(shoppingCart);
        }
    }

    @Override
    public List<Order> getUserOrders(Long userId) {
        if( (daoOrder.getUserOrders(userId)).isEmpty()) {
            System.out.println("This user has no orders");
            return null;
        }

        return daoOrder.getUserOrders(userId);
    }

    @Override
    public Order get(Long id) {
       if(daoOrder.get(id) == null) {
           System.out.println("The specified order does not exist");
       }
        return daoOrder.get(id);
    }

    @Override
    public List<Order> getAll() {
        return daoOrder.getAll();
    }

    @Override
    public boolean delete(Long id) {
      if( daoOrder.delete(id)==false) {
          System.out.println("The specified order does not exist");
      }
        return  daoOrder.delete(id);
    }
}
