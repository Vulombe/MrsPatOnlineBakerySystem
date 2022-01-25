package za.co.bakery.service;

import java.util.List;
import za.co.bakery.dbao.UserDOA;
import za.co.bakery.dbao.impl.UserDOAImpl;
import za.co.bakery.domain.User;
import za.co.bakery.manager.DBPoolManagerBasic;

public class UserServiceImpl implements UserService {

    private UserDOA userdao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(DBPoolManagerBasic dbpm) {
        this.userdao = new UserDOAImpl(dbpm);
    }

    @Override
    public boolean isUserValid(String email, String password) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        if (password == null || password.isEmpty()) {
            return false;
        }
        return userdao.isUserValid(email, password);
    }

    @Override
    public User create(String title, String firstName, String lastName, String emailAddress,
            String contactNumber, String password, String passwordConfirm) {
        //error check all parameters
        if (emailAddress != null) {    // if it is null, then what?
            emailAddress = emailAddress.toLowerCase();
        }

        User user = new User(title, firstName, lastName, emailAddress, contactNumber, password);
        return (userdao.create(user) > 0) ? user : null;
    }

    @Override
    public List<User> getUsers() {
         return null;   //userdao.readAll();
    }

    @Override
    public User read(User u) {
        return userdao.read(u);
    }

    @Override
    public boolean read(String title, String firstName, String lastName, String emailAddress,
            String contactNumber, String password) {

        if (emailAddress == null || emailAddress.isEmpty()) {
            return false;
        }
        User user = userdao.read(emailAddress);

        if (title != null) {
            user.setTitle(title);
        }
        if (lastName != null) {
            user.setLastName(lastName);
        }
        if (firstName != null) {
            user.setFirstName(firstName);
        }
        if (contactNumber != null) {
            user.setContactNumber(contactNumber);
        }
        if (password != null) {
            user.setPassword(password);
        }
        return update(user);
    }

    @Override
    public User read(String email) {
        return userdao.read(email);
    }

    @Override
    public boolean delete(String email) {
        if(email==null || email.isEmpty()){
            return false;
        }
        return userdao.delete(email);
    }

    @Override
    public boolean update(User u) {
        return userdao.update(u);
    }

}
