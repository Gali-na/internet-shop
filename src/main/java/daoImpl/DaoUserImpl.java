package daoImpl;

import Storage.StorageUser;
import dao.DaoUser;
import model.User;

import java.util.List;
import java.util.Optional;

public class DaoUserImpl implements DaoUser {
    @Override
    public User create(User user) {
        StorageUser.users.add(user);
        return user;
    }

    @Override
    public User get(Long id) {
        Optional<User> person = StorageUser.users.stream()
                .filter(user -> user.getUserId().equals(id))
                .findFirst();
        if (person.isPresent()) {
            return person.get();
        }
        return null;
    }

    @Override
    public List<User> getAll() {

        return StorageUser.users;
    }

    @Override
    public User update(User user) {
        Optional<Integer> index = StorageUser.users.stream()
                .filter(person -> person.getUserId().equals(user.getUserId()))
                .map(person -> StorageUser.users.indexOf(person))
                .findFirst();
        if (index.isPresent()) {
            int indexUserForupdate = index.get();
            return StorageUser.users.set(indexUserForupdate, user);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Optional<User> user = StorageUser.users.stream()
                .filter(person -> person.getUserId().equals(id))
                .findFirst();
        if (user.isPresent()) {
            User userForDelete = user.get();
            return StorageUser.users.remove(userForDelete);
        }
        return false;
    }
}

