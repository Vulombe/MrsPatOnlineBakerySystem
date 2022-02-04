package za.co.bakery.dbao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import za.co.bakery.dbao.OrderDAO;
import za.co.bakery.dbao.ProductLineItemDAO;
import za.co.bakery.dbao.UserAddressDAO;
import za.co.bakery.dbao.UserDOA;
import za.co.bakery.dbao.cartDAO;
import za.co.bakery.domain.IngredientItem;
import za.co.bakery.domain.LineItem;
import za.co.bakery.domain.LineItemCollection;
import za.co.bakery.domain.Order;
import za.co.bakery.domain.User;
import za.co.bakery.manager.DBPoolManagerBasic;

public class OrderDAOImpl implements OrderDAO {

    final private DBPoolManagerBasic dbpm;
    private Connection con = null;
    private PreparedStatement ps;
    private PreparedStatement ps1;
    private ResultSet rs;
    private ResultSet rs1;
    private UserDOA userDOA;
    private ProductLineItemDAO productLineItemDAO;
    private UserAddressDAO userAddressDAO;
    private cartDAO cartDA;
// ************************************************************************

    public OrderDAOImpl(DBPoolManagerBasic dbpm) {
        this.dbpm = dbpm;
        this.userAddressDAO = new UserAddressDAOImpl(dbpm);
        this.userDOA = new UserDOAImpl(dbpm);
        this.productLineItemDAO = new ProductLineItemDAOImpl(dbpm);
        this.cartDA = new CartDAOImpl(dbpm);

    }

    @Override
    public boolean add(Order o) {
        boolean isAdded = false;
        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("INSERT INTO orders ( orderId,userEmail,addressId, totalPrice,orderDate,isActive) VALUES(null,?,?,?,?,'Y')");

            ////////////////////////////////////////////////////////////////////
            ps.setString(1, o.getUser().getEmailAddress());
            ps.setInt(2, o.getUserAddress().getAddressId());
            ps.setDouble(3, o.getLineItem().grandTotal());
            ps.setString(4, o.getOrdrDate().toString());

            if (ps.executeUpdate() > 0) {
                isAdded = true;
            }
            boolean cart = cartAdd(o);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {

            closeStreams();

        }
        return isAdded;
    }

    public boolean cartAdd(Order o) {
        boolean isAdded = false;
        try {
            con = dbpm.getConnection();

            ps1 = con.prepareStatement("SELECT * FROM ORDERS WHERE ORDERID=(SELECT MAX(ORDERID)FROM ORDERS)");
            rs = ps1.executeQuery();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt("orderId");
            }
            o.setOrderID(id);
            cartDA.addcartLine(o);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return isAdded;
    }

    @Override
    public Order readOrder(Order o) {

        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM ORDERS WHERE ORDERID=?");
            ps.setInt(1, o.getOrderID());
            rs = ps.executeQuery();

            if (rs.next()) {
                o = new Order();
                o.setOrderID(rs.getInt("orderId"));
                User u = userDOA.read(rs.getString("userEmail"));
                o.setUser(u);
                LineItemCollection productItemList = new LineItemCollection();
                productItemList.setCart(cartDA.readCart(o.getOrderID()));
                o.setLineItem(productItemList);

                o.setUserAddress(userAddressDAO.readUserAddress(u));
                o.setTotalPrice(rs.getDouble("totalPrice"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeStreams();
        }
        return o;
    }

    @Override
    public Order readOrder(int OrderId) {
        Order o = null;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM ORDERS WHERE ORDERID=?");
            ps.setInt(1, OrderId);
            rs = ps.executeQuery();

            if (rs.next()) {
                o = new Order();
                o.setOrderID(rs.getInt("orderId"));
                User u = userDOA.read(rs.getString("userEmail"));
                o.setUser(u);

                LineItemCollection productItemList = new LineItemCollection();
                productItemList.setCart(cartDA.readCart(o.getOrderID()));
                o.setLineItem(productItemList);

                o.setUserAddress(userAddressDAO.readUserAddress(u));
                o.setTotalPrice(rs.getDouble("totalPrice"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeStreams();
        }
        return o;
    }

    @Override
    public Order readOrder(User u) {
        Order o = null;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM ORDERS WHERE USEREMAIL=?");
            ps.setString(1, u.getEmailAddress());
            rs = ps.executeQuery();

            if (rs.next()) {
                o = new Order();
                o.setOrderID(rs.getInt("orderId"));
                o.setUser(u);
                String productsItemIds = rs.getString("productLineItemId");
                LineItemCollection productItemList = new LineItemCollection();
                productItemList.setCart(cartDA.readCart(o.getOrderID()));
                o.setLineItem(productItemList);

                o.setUserAddress(userAddressDAO.readUserAddress(u));
                o.setTotalPrice(rs.getDouble("totalPrice"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeStreams();
        }
        return o;
    }

    @Override
    public List<Order> listOrder() {
        List<Order> orders = new ArrayList<>();

        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM ORDERS");
            rs = ps.executeQuery();

            while (rs.next()) {
                Order o = new Order();
                o.setOrderID(rs.getInt("orderId"));
                User u = userDOA.read(rs.getString("userEmail"));
                o.setUser(u);

                LineItemCollection productItemList = new LineItemCollection();
                productItemList.setCart(cartDA.readCart(o.getOrderID()));
                o.setLineItem(productItemList);

                o.setUserAddress(userAddressDAO.readUserAddress(u));
                o.setTotalPrice(rs.getDouble("totalPrice"));
                orders.add(o);
            }

        } catch (SQLException ex) {
        } finally {
            closeStreams();
        }

        return orders;
    }

    @Override
    public List<Order> listOrder(User u) {
        List<Order> orders = new ArrayList<>();

        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM ORDERS WHERE  CUSTEMAIL=?");
            ps.setString(1, u.getEmailAddress());
            rs = ps.executeQuery();

            while (rs.next()) {
                Order o = new Order();
                o.setOrderID(rs.getInt("orderId"));
                o.setUser(u);
                String productsItemIds = rs.getString("productLineItemId");
                LineItemCollection productItemList = new LineItemCollection();
                productItemList.setCart(cartDA.readCart(o.getOrderID()));
                o.setLineItem(productItemList);

                o.setUserAddress(userAddressDAO.readUserAddress(u));
                o.setTotalPrice(rs.getDouble("totalPrice"));
                orders.add(o);
            }

        } catch (SQLException ex) {
        } finally {
            closeStreams();
        }

        return orders;
    }

    @Override
    public boolean update(Order o) {
        boolean isUpdated = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("UPDATE ORDERS SET USEREMAIL=?,ADDRESSID=?,TOTALPRICE=? WHERE ORDERID=?");

            ps.setString(1, o.getUser().getEmailAddress());
            ps.setInt(3, o.getUserAddress().getAddressId());
            ps.setDouble(4, o.getTotalPrice());
            if (ps.executeUpdate() > 0) {
                isUpdated = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();

        }
        return isUpdated;
    }

    @Override
    public boolean delete(Order o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
