/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.dbao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.bakery.dbao.UserAddressDAO;
import za.co.bakery.dbao.UserDOA;
import za.co.bakery.domain.User;
import za.co.bakery.domain.UserAddress;
import za.co.bakery.manager.DBPoolManagerBasic;

/**
 *
 * @author Studio13
 */
public class UserAddressDAOImpl implements UserAddressDAO {

    final private DBPoolManagerBasic dbpm;
    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;
    private UserDOA userDOA;

// ************************************************************************
    public UserAddressDAOImpl(DBPoolManagerBasic dbpm) {
        this.dbpm = dbpm;
    }

    //*****************add product to database*******************************
    @Override
    public boolean add(UserAddress ua) {
        boolean isAdded = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("INSERT INTO ADDRESS(addressId,houseNumber,street,city,state, code,custEmail,isActive) VALUES(null,?,?,?,?,?,?,'Y')");
            //  ps.setInt(1, p.getProductID());
            ps.setInt(1, ua.getHouseNumber());
            ps.setString(2, ua.getStreetName());
            ps.setString(3, ua.getCity());
            ps.setString(4, ua.getState());
            ps.setString(5, ua.getZipCode());
            ps.setString(6, ua.getUser().getEmailAddress());
            isAdded = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return isAdded;
    }

    @Override
    public UserAddress readUserAddress(User u) {
        UserAddress ua = null;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM ADDRESS WHERE CUSTEMAIL=?");
            ps.setString(1, u.getEmailAddress());
            rs = ps.executeQuery();

            if (rs.next()) {
                ua = new UserAddress(rs.getInt("addressId"),rs.getInt("houseNumber"),rs.getString("street"),rs.getString("city"),rs.getString("state"),rs.getString("code"),u);
//                ua.setAddressId(rs.getInt("addressId"));
//                ua.setHouseNumber(rs.getInt("houseNumber"));
//                ua.setStreetName(rs.getString("street"));
//                ua.setCity(rs.getString("city"));
//                ua.setState(rs.getString("state"));
//                ua.setZipCode(rs.getString("code"));
//                ua.setUser(u);
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }
        System.out.println(ua);
        return ua;
    }

    @Override
    public UserAddress readUserAddressById(int AddressId) {
        UserAddress ua = null;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM ADDRESS WHERE ADDRESSID= ?");
            ps.setInt(1, AddressId);
            rs = ps.executeQuery();

            if (rs.next()) {
                ua = new UserAddress();
                ua.setAddressId(rs.getInt("addressId"));
                ua.setHouseNumber(rs.getInt("houseNumber"));
                ua.setStreetName(rs.getString("street"));
                ua.setCity(rs.getString("city"));
                ua.setState(rs.getString("state"));
                ua.setZipCode(rs.getString("code"));
                ua.setUser(userDOA.read(rs.getString("custEmail")));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }

        return ua;
    }

    @Override
    public User readAddress(UserAddress ua) {
        User u = null;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM ADDRESS WHERE ADDRESSID= ?");
            ps.setInt(1, ua.getAddressId());
            rs = ps.executeQuery();

            if (rs.next()) {
                u = userDOA.read(rs.getString("custEmail"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }

        return u;
    }

    @Override
    public List<UserAddress> readAll() {
        List<UserAddress> userAddresses = new ArrayList<>();

        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM ADDRESS");
            rs = ps.executeQuery();

            while (rs.next()) {
                UserAddress ua = new UserAddress();
                ua.setAddressId(rs.getInt("addressId"));
                ua.setHouseNumber(rs.getInt("houseNumber"));
                ua.setStreetName(rs.getString("street"));
                ua.setCity(rs.getString("city"));
                ua.setState(rs.getString("state"));
                ua.setZipCode(rs.getString("code"));
                ua.setUser(userDOA.read(rs.getString("custEmail")));
                userAddresses.add(ua);

            }

        } catch (SQLException ex) {
        } finally {
            closeStreams();
        }

        return userAddresses;
    }

    @Override
    public List<User> readAllProductOfIngredient(UserAddress ua) {
        List<User> users = new ArrayList<>();

        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM ADDRESS WHERE ADDRESSID=?");
            ps.setInt(1, ua.getAddressId());
            rs = ps.executeQuery();

            while (rs.next()) {
                User u = userDOA.read(rs.getString("custEmail"));
                users.add(u);

            }

        } catch (SQLException ex) {
        } finally {
            closeStreams();
        }

        return users;
    }

    @Override
    public boolean update(UserAddress ua) {
        boolean isUpdated = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("UPDATE ADDRESS SET HOUSENUMBER=?,STREET=?,CITY=?,STATE=?,CODE=?,CUSTEMAIL=? WHERE ADDRESSID=?");

            ps.setInt(1, ua.getHouseNumber());
            ps.setString(2, ua.getStreetName());
            ps.setString(3, ua.getCity());
            ps.setString(4, ua.getState());
            ps.setString(5, ua.getZipCode());
            ps.setString(6, ua.getUser().getEmailAddress());
            ps.setInt(7, ua.getAddressId());
            isUpdated = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();

        }
        return isUpdated;
    }

    @Override
    public boolean delete(UserAddress ua) {
        boolean isDeleted = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("UPDATE ADDRESS SET ISACTIVE=? WHERE ADDRESSID=?");
            ps.setString(1, "N");
            ps.setInt(2, ua.getAddressId());
            isDeleted = ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }

        return isDeleted;
    }

    private void closeStreams() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Error closing ResultSet: " + ex.getMessage());
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println("Error closing PreparedStatement: " + ex.getMessage());
            }
        }
        if (rs != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error closing Connection: " + ex.getMessage());
            }
        }
        rs = null;
        ps = null;
        con = null;
    }

}