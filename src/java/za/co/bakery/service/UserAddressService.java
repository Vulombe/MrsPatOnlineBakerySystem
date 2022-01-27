/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.service;

import java.util.List;
import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;

/**
 *
 * @author student12
 */
public interface UserAddressService {

    public boolean add(int houseNumber,String streetAddress, String city,String state,String zipCode,User user);

    public UserAddress readUserAddress(User u);

    public UserAddress readUserAddressById(int AddressId);

    public User readAddress(UserAddress ua);

    public List<UserAddress> readAll();

    public List<User> readAllProductOfIngredient(UserAddress ua);
    
    public boolean checkAddressErrors(int houseNumber,String streetAddress, String city,String state,String zipCode,User user);
    
    public boolean update(UserAddress ua,int houseNumber,String streetAddress, String city,String state,String zipCode,User user);

    public boolean delete(UserAddress ua);
}
