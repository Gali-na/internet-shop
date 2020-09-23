package daoImpl;

import Storage.StorageOrder;
import Storage.StorageUser;
import dao.DaoUser;
import model.User;

public class DaoUserImpl implements DaoUser {

    @Override
    public void add(User user) {
        StorageUser.users.add(user);
    }
}
