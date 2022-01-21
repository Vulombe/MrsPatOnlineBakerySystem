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
    public boolean isUserValid(String email, String password) 
    { return userdao.isUserValid(email, password);
    }

    @Override
    public void create(String title, String lastName, String firstName, String email, String password) {
        // return userdao.create(u);
    }

    @Override
    public List<User> getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User read(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
