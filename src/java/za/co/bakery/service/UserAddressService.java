
package za.co.bakery.service;

import java.util.List;
import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;


public interface UserAddressService {

    public boolean add(int houseNumber,String streetAddress, String city,String state,String zipCode,User user);

    public UserAddress readUserAddress(User u);

    public UserAddress readUserAddressById(int AddressId);

    public User readAddress(UserAddress ua);

    public List<UserAddress> readAll();

    public List<User> readAllProductOfIngredient(UserAddress ua);
    
    public boolean checkAddressErrors(int houseNumber,String streetAddress, String city,String state,String zipCode,User user);
    
    public boolean update(UserAddress userAddress);
    public boolean readtoUpdate(int houseNumber,String streetAddress, String city,String state,String zipCode,User user);

    public boolean delete(UserAddress ua);
}