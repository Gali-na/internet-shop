package service;

import model.User;

import java.util.List;
import java.util.Optional;

public interface GnericServise <T,V> {
    T create(T element);

    Optional<T> get(V id);

    List<T> getAll();

    T update(T element);

    boolean delete(Long id);
}
