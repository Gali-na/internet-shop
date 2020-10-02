package dao;

import model.Order;
import model.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface GenericDao <T,K> {
    T create(T element);

    Optional<T> get( K id);

    T update(T element);

    List<T> getAll();

    boolean delete(K id);
}
