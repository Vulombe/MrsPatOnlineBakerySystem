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
        User user = null;
        String errorMessage = null;
        if (emailAddress == null || emailAddress.isEmpty()) {
            errorMessage = "Email Address cannot be null";
        }
        if (password == null || password.isEmpty()) {
            errorMessage = "Password cannot be null";
        }
        if (title == null || title.isEmpty()) {
            errorMessage = "Title cannot be null";
        }
        if (firstName == null || firstName.isEmpty()) {
            errorMessage = "First Name cannot be null";
        }
           if (lastName == null || lastName.isEmpty()) {
            errorMessage = "Last Name cannot be null";
        }
        if (contactNumber == null || contactNumber.isEmpty()) {
            errorMessage = "Contact Number cannot be null";
        }
        if (password == null || password.isEmpty()) {
            errorMessage = "Password cannot be null";
        }
        if (passwordConfirm == null || passwordConfirm.isEmpty()) {
            errorMessage = "First Name cannot be null";
        }
        if (emailAddress != null) {    // if it is null, then what?
            emailAddress = emailAddress.toLowerCase();
        }
        if(errorMessage !=null){
            if(password.equals(passwordConfirm))
                user = new User(title, firstName, lastName, emailAddress, contactNumber, password);
        }
        return (userdao.create(user) > 0) ? user : null;
    }

    @Override
    public List<User> getUsers() {
         return userdao.readUsers();
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

        if (title != null || !title.isEmpty()) {
            user.setTitle(title);
        }
        if (lastName != null || !lastName.isEmpty()) {
            user.setLastName(lastName);
        }
        if (firstName != null || !firstName.isEmpty()) {
            user.setFirstName(firstName);
        }
        if (contactNumber != null || !contactNumber.isEmpty()) {
            user.setContactNumber(contactNumber);
        }
        if (password != null || !password.isEmpty()) {
            user.setPassword(password);
        }
        return update(user);
    }

    @Override
    public User read(String emailAddress) {
         if (emailAddress == null || emailAddress.isEmpty()) {
            return null;
        }
        return userdao.read(emailAddress);
    }

    @Override
    public boolean delete(String emailAddress) {
        if(emailAddress==null || emailAddress.isEmpty()){
            return false;
        }
        return userdao.delete(emailAddress);
    }

    @Override
    public boolean update(User u) {
        return userdao.update(u);
    }

}
