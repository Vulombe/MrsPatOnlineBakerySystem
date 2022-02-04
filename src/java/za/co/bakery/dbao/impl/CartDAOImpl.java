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
import za.co.bakery.dbao.ProductDAO;
import za.co.bakery.dbao.cartDAO;
import za.co.bakery.domain.LineItem;
import za.co.bakery.domain.LineItemCollection;
import za.co.bakery.domain.Order;
import za.co.bakery.domain.Product;
import za.co.bakery.manager.DBPoolManagerBasic;

/**
 *
 * @author Studio13
 */
public class CartDAOImpl implements cartDAO {

    final private DBPoolManagerBasic dbpm;
    private Connection con = null;
    private PreparedStatement ps;
    private PreparedStatement ps1;
    private PreparedStatement psIsLineItemValid;
    private PreparedStatement psUpdateQty;
    private ResultSet rs;
    private ProductDAO productDAO;
// ************************************************************************

    public CartDAOImpl(DBPoolManagerBasic dbpm) {
        this.dbpm = dbpm;
        this.productDAO = new ProductDAOImpl(dbpm);
    }

    @Override
    public boolean addcartLine(Order o) {
        boolean isAdded = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("INSERT INTO CARTLINEITEMS(cartLineItemsId,productId,qty,orderId,isActive) VALUES(null,?,?,?,'Y')");
            //  ps.setInt(1, p.getProductID());
            List<LineItem> cart = o.getLineItem().getCart();
            for (LineItem lineItem : cart) {
                ps.setInt(1, lineItem.getProduct().getProductID());
                ps.setInt(2, lineItem.getQty());
                ps.setInt(3, o.getOrderID());

                if (ps.executeUpdate() > 0) {
                    isAdded = true;
                }

            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return isAdded;
    }

    @Override
    public LineItem readCartLine(int lineItemCollectionId) {

        LineItem l = null;
        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM CARTLINEITEMS WHERE cartLineItemsId= ?");
            ps.setInt(1, lineItemCollectionId);
            rs = ps.executeQuery();

            if (rs.next()) {
                l = new LineItem(rs.getInt("cartLineItemsId"), productDAO.read(rs.getInt("productId")), rs.getInt("qty"));

            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }

        return l;

    }

    @Override
    public List<LineItem> readCart(int orderId) {
        List<LineItem> lineItems = new ArrayList<>();
        LineItem l = null;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM CARTLINEITEMS WHERE ORDERID= ?");
            ps.setInt(1, orderId);
            rs = ps.executeQuery();

            while (rs.next()) {

                l = new LineItem(rs.getInt("lineItemId"), productDAO.read(rs.getInt("productId")), rs.getInt("qty"));
                lineItems.add(l);

            }

        } catch (SQLException ex) {
        } finally {
            closeStreams();
        }

        return lineItems;
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
