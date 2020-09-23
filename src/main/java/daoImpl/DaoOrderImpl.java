package daoImpl;

import Storage.StorageOrder;
import dao.DaoOrder;
import model.Order;

public class DaoOrderImpl implements DaoOrder {
    @Override
    public void add(Order order) {
        StorageOrder.orders.add(order);

    }
}
