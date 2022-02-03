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
            ps = con.prepareStatement("SELECT * FROM USER WHERE EMAIL =? AND PASSWORD =? AND ISACTIVE=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, "Y");
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
                ps = con.prepareStatement("INSERT INTO USER (id,title,firstName,lastName,email,contactNumber,password,isClient)VALUE(null,?,?,?,?,?,?,?)");
                //ps.setInt(1, u.getID());
                ps.setString(1, u.getTitle());
                ps.setString(2, u.getFirstName());
                ps.setString(3, u.getLastName());
                ps.setString(4, u.getEmailAddress());
                ps.setString(5, u.getContactNumber());
                ps.setString(6, u.getPassword());

                if (u.getUserRole().toString().toLowerCase().equals("admin")) {
                    ps.setString(7, "N");
                } else {
                    ps.setString(7, "Y");
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
        User u = null;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM USER");
            rs = ps.executeQuery();

            if (rs.next()) {
                u = new User();
                u.setPassword(rs.getString("password"));
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
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeStreams();
        }
        return u;
    }

    @Override
    public User read(String email) {
        User u = null;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM USER WHERE EMAIL=?");
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                u = new User();
                u.setPassword(rs.getString("password"));
                u.setID(rs.getInt("Id"));
                u.setTitle(rs.getString("title"));
                u.setFirstName(rs.getString("firstName"));
                u.setLastName(rs.getString("lastName"));
                u.setContactNumber(rs.getString("contactNumber"));
                u.setEmailAddress(email);
                String userRole = rs.getString("isClient");
                if (userRole.equalsIgnoreCase("Y")) {
                    u.setUserRole(Role.CLIENT);
                } else {
                    u.setUserRole(Role.ADMIN);
                }

            }
        } catch (SQLException e) {
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
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            closeStreams();
        }
        return true;
    }

    //***********updating user ******************************************
    @Override
    public boolean update(User u) {
        boolean isUpdated = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("update user set title=?,firstName=?,lastName=?,contactNumber=?,password=?,isClient=? where email=?");

            ps.setString(1, u.getTitle());
            ps.setString(2, u.getFirstName());
            ps.setString(3, u.getLastName());
            ps.setString(4, u.getContactNumber());
            ps.setString(5, u.getPassword());
            if (u.getUserRole().toString().toLowerCase().equals("admin")) {
                ps.setString(6, "N");
            } else {
                ps.setString(6, "Y");
            }
            ps.setString(7, u.getEmailAddress());

            ps.executeUpdate();
            isUpdated = true;

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();

        }
        return isUpdated;
    }

    @Override
    public boolean delete(String email) {
        boolean isDeleted = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("update user set isActive=? where email=?");
            ps.setString(1, "N");
            ps.setString(2, email);
            ps.executeUpdate();
            isDeleted = true;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }

        return isDeleted;
    }
    
    public List<User> readUsers()
    {
    
     List<User> users= new ArrayList<>();
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM USER");
            rs = ps.executeQuery();

            while(rs.next()) {
                User u  = new User();
                u.setPassword(rs.getString("password"));
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
                users.add(u);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeStreams();
        }
        return users;
    
    
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
