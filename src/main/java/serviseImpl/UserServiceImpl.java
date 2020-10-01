package serviseImpl;

import Storage.StorageOrder;
import Storage.StorageUser;
import dao.DaoUser;
import daoImpl.DaoUserImpl;
import service.UserService;
import model.User;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Override
    public User create(User user) {
        // Нужен инжектор
        DaoUser daoUser =new DaoUserImpl();
        if(user.getName()==null|| user.getName()==" " || user.getName()=="") {
            System.out.println("The username was entered incorrectly, please enter the name again.");
            return null;
        }
        if(user.getName().length()>20) {
            System.out.println( "You have exceeded the maximum number of characters, please re-enter your username.");
            return null;
        }
        if(user.getPassword().length()>20) {
            System.out.println("The number of characters for setting the password has been exceeded.");
            return null;
        }
        if(user.getPassword().length()<20) {
            System.out.println("The entered number of characters is at least 20, please re-enter your password.");
            return null;
        }
        if(user.getUserId()==0) {
            System.out.println("User user has an incorrect identifier, please re-enter this product");
            return null;
        }
        Optional<User> userCheck= StorageUser.users.stream()
                .filter(us -> us.getUserId().equals(user.getUserId()))
                .findFirst();
        if(userCheck.isPresent() ) {
            System.out.println("The user  has an incorrect identifier, please re-enter this product");
        }
        else {
            daoUser.create(user);
            return user;
        }
        return null;
    }

    @Override
    public User get(Long id) {
        // Нужен инжектор
        DaoUser daoUser =new DaoUserImpl();
        return daoUser.get(id);
    }

    @Override
    public List<User> getAll() {
        // Нужен инжектор
        DaoUser daoUser =new DaoUserImpl();
        return daoUser.getAll();
    }

    @Override
    public User update(User user) {
        // Нужен инжектор
        DaoUser daoUser =new DaoUserImpl();
        if(user.getName()==null|| user.getName()==" " || user.getName()=="") {
            System.out.println("The username was entered incorrectly, please enter the name again.");
            return null;
        }
        if(user.getName().length()>20) {
            System.out.println( "You have exceeded the maximum number of characters, please re-enter your username.");
            return null;
        }
        if(user.getPassword().length()>20) {
            System.out.println("The number of characters for setting the password has been exceeded.");
            return null;
        }
        if(user.getPassword().length()<20) {
            System.out.println("The entered number of characters is at least 20, please re-enter your password.");
            return null;
        }

        else {
            daoUser.update(user);
            return user;
        }
    }

    @Override
    public boolean delete(Long id) {
        // Нужен инжектор
        DaoUser daoUser = new DaoUserImpl();

        if (!daoUser.delete(id)) {
            System.out.println("You have entered an incorrect ID, please enter it again.");
            return false;
        } else {
            return daoUser.delete(id);
        }
    }
}
