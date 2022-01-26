package za.co.bakery.service;

import java.util.List;
import za.co.bakery.dbao.UserAddressDAO;
import za.co.bakery.dbao.impl.UserAddressDAOImpl;
import za.co.bakery.dbao.impl.UserDOAImpl;
import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;
import za.co.bakery.manager.DBPoolManagerBasic;

public class UserAddressServiceImpl implements UserAddressService {

    private UserAddressDAO userAddressDAO;

    public UserAddressServiceImpl(DBPoolManagerBasic dbpm) {
        this.userAddressDAO = new UserAddressDAOImpl(dbpm);
    }

    @Override
    public boolean add(int houseNumber, String streetAddress, String city, String state, String zipCode, User user) {
        UserAddress userAddress = null;
        //boolean checkErrors = checkAddressErrors(houseNumber,streetAddress,city,state,zipCode,user);

        userAddress = new UserAddress(houseNumber, streetAddress, city, state, zipCode, user);
        return userAddressDAO.add(userAddress);

    }

    @Override
    public UserAddress readUserAddress(User user) {
        if (user.getEmailAddress() == null || user.getEmailAddress().isEmpty()) {
            return null;
        }
        return userAddressDAO.readUserAddress(user);
    }

    @Override
    public UserAddress readUserAddressById(int addressId) {
        if (addressId < 0) {
            return null;
        }
        return userAddressDAO.readUserAddressById(addressId);
    }

    @Override
    public User readAddress(UserAddress ua) {
        if (ua.getAddressId() <= 0) {
            return null;
        }
        return userAddressDAO.readAddress(ua);
    }

    @Override
    public List<UserAddress> readAll() {
        return userAddressDAO.readAll();
    }

    @Override
    public List<User> readAllProductOfIngredient(UserAddress ua) {
        if (ua.getAddressId() <= 0) {
            return null;
        }
        return userAddressDAO.readAllProductOfIngredient(ua);
    }

    @Override
    public boolean update(UserAddress ua, int houseNumber, String streetAddress, String city, String state, String zipCode, User user) {

        if (ua.getAddressId() <= 0) {
            return false;
        }
        boolean checkErrors = checkAddressErrors(houseNumber, streetAddress, city, state, zipCode, user);
        if (checkErrors) {
            return userAddressDAO.update(ua);
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(UserAddress ua) {
        if (ua.getAddressId() <= 0) {
            return false;
        }
        return userAddressDAO.delete(ua);
    }

    @Override
    public boolean checkAddressErrors(int houseNumber, String streetAddress, String city, String state, String zipCode, User user) {
        if (houseNumber < 0) {
            return false;
        }
        if (streetAddress == null || streetAddress.isEmpty()) {
            return false;
        }
        if (city == null || city.isEmpty()) {
            return false;
        }
        if (state == null || state.isEmpty()) {
            return false;
        }
        if (zipCode == null || zipCode.isEmpty()) {
            return false;
        }
        if (user.getEmailAddress() == null || user.getEmailAddress().isEmpty()) {
            return false;
        }

        return true;
    }

}
