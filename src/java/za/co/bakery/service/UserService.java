package za.co.bakery.service;


import java.util.List;
import za.co.bakery.domain.User;


public interface UserService {
 
    User create(String title, String firstName, String lastName, String emailAddress, String contactNumber, String password);
    boolean isUserValid(String email,String password);
    public User read(User u);
    public User read(int id);
    public boolean delete(String email);
    public boolean update(User u);
    List<User> getUsers();
}





