package za.co.bakery.service;


import java.util.List;
import za.co.bakery.domain.User;


public interface UserService {
 
    void create(String title,String lastName,String firstName,String email, String password);
    boolean isUserValid(String email,String password);
    public User read(User u);
    List<User> getUsers();
}





