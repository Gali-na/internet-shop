package service;

import model.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends GnericServise<User,Long>{

    User create(User user);

    Optional<User> get(Long id);

    List<User> getAll();

    User update(User user);

    boolean delete(Long id);
}
