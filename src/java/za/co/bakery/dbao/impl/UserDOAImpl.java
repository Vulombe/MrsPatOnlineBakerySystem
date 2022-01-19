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
import java.util.List;
import za.co.bakery.dbao.UserDOA;
import za.co.bakery.domain.Role;
import za.co.bakery.domain.User;
import za.co.bakery.manager.DBPoolManagerBasic;

/**
 *
 * @author student12
 */
public class UserDOAImpl implements UserDOA {
    //***************Getting the Database connection from the contex********************   

    private DBPoolManagerBasic dbpm;
    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;

    public UserDOAImpl() {
    }
// ************************************************************************

    public UserDOAImpl(DBPoolManagerBasic dbpm) {
        this.dbpm = dbpm;
    }

// ************************************************************************
    @Override
    public boolean isUserValid(String email, String password) {
        boolean isValid = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM USER WHERE EMAIL =? AND PASSWORD =?");
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            isValid = rs.next();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return isValid;
    }

    @Override
    public int create(User u) {
        int i = 0;
        try {
            if (isNewUser(u)) {
                con = dbpm.getConnection();
                ps = con.prepareStatement("INSERT INTO USER VALUE(?,?,?,?,?,?,?,?)");
                ps.setInt(1, u.getID());
                ps.setString(2, u.getTitle());
                ps.setString(3, u.getFirstName());
                ps.setString(4, u.getLastName());
                ps.setString(5, u.getEmailAddress());
                ps.setString(6, u.getContactNumber());
                ps.setString(7, u.getPassword());

                if (u.getUserRole().toString().toLowerCase().equals("admin")) {
                    ps.setString(8, "N");
                } else {
                    ps.setString(8, "Y");
                }
                ps.executeUpdate();

            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            closeStreams();
        }
        return i;
    }

    @Override
    public User read() {
        User u=null;
       try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM USER WHERE EMAIL=?");
            ps.setString(1, u.getEmailAddress());
            rs = ps.executeQuery();

            if (rs.next()) {
                u= new User();
                if (rs.getString("password").equals(u.getPassword())) {
                    u.setID(rs.getInt("Id"));
                    u.setTitle("title");
                    u.setFirstName(rs.getString("firstName"));
                    u.setLastName(rs.getString("lastName"));
                    u.setContactNumber(rs.getString("contactNumber"));
                    String userRole = rs.getString("isClient");
                    if (userRole.equalsIgnoreCase("Y")) {
                        u.setUserRole(Role.CLIENT);
                    } else {
                        u.setUserRole(Role.ADMIN);
                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeStreams();
        }
        return u;
    }

    @Override
    public User read(User u) {
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM USER WHERE EMAIL=?");
            ps.setString(1, u.getEmailAddress());
            rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getString("password").equals(u.getPassword())) {
                    u.setID(rs.getInt("Id"));
                    u.setTitle("title");
                    u.setFirstName(rs.getString("firstName"));
                    u.setLastName(rs.getString("lastName"));
                    u.setContactNumber(rs.getString("contactNumber"));
                    String userRole = rs.getString("isClient");
                    if (userRole.equalsIgnoreCase("Y")) {
                        u.setUserRole(Role.CLIENT);
                    } else {
                        u.setUserRole(Role.ADMIN);
                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            closeStreams();
        }
        return u;
    }

    @Override
    public boolean isNewUser(User u) {
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM USER WHERE EMAIL=?");
            ps.setString(1, u.getEmailAddress());
            rs = ps.executeQuery();

            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            closeStreams();
        }
        return true;
    }

// ***********************************Clossing the connection************************************
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
    // ************************************************************************

}
