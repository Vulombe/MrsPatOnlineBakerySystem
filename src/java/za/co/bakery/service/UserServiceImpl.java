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
//        boolean isUserValid = false;
//        boolean valid = userdao.isUserValid(email, password);
//        if (valid) {
//            User user = userdao.read();
//            String uEmail = user.getEmailAddress();
//            String uPassword = user.getPassword();
//            if (!uEmail.equals(email) || !uPassword.equals(password)) {
//                isUserValid = true;
//            }
//
//        }
        boolean t = userdao.isUserValid(email, password);
        return t;
        // return userdao.isUserValid(email, password);
    }

    @Override
    public User create(String title, String firstName, String lastName, String emailAddress, String contactNumber, String password) {
        User user = new User(title, firstName, lastName, emailAddress, contactNumber, password);
        return (userdao.create(user) > 0) ? user:null;
    }

    @Override
    public List<User> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User read(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
