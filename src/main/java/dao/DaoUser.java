package dao;

import model.User;

import java.util.List;

public interface DaoUser {
    User create(User user);

    User get(Long id);

    List<User> getAll();

    User update(User user);

    boolean delete(Long id);
}
