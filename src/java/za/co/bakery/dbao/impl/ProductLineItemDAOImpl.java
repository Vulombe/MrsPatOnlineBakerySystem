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
import za.co.bakery.dbao.ProductLineItemDAO;

import za.co.bakery.domain.LineItem;

import za.co.bakery.domain.Product;
import za.co.bakery.manager.DBPoolManagerBasic;

/**
 *
 * @author Studio13
 */
public class ProductLineItemDAOImpl implements ProductLineItemDAO {

    final private DBPoolManagerBasic dbpm;
    private Connection con = null;
    private PreparedStatement ps;
    private PreparedStatement psIsLineItemValid;
    private PreparedStatement psUpdateQty;
    private ResultSet rs;
    private ProductDAO productDAO;
// ************************************************************************

    public ProductLineItemDAOImpl(DBPoolManagerBasic dbpm) {
        this.dbpm = dbpm;
        this.productDAO = new ProductDAOImpl(dbpm);
    }

    //*****************add product to database*******************************
    @Override
    public boolean addProductLineItem(LineItem li) {
        boolean isAdded = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("INSERT INTO PRODUCTLINEITEMS(lineItemId,productId,qty,isActive) VALUES(null,?,?,null)");

            //  ps.setInt(1, p.getProductID());
            Product p = li.getProduct();
            ps.setInt(1, p.getProductID());
            ps.setInt(2, li.getQty());

            if (ps.executeUpdate() > 0) {
                isAdded = true;
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }
        return isAdded;
    }

    @Override
    public LineItem readProductLineItem(int lineItemId) {
        LineItem l = null;
        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM PRODUCTLINEITEMS WHERE LINEITEMID= ?");
            ps.setInt(1, lineItemId);
            rs = ps.executeQuery();

            if (rs.next()) {
                l = new LineItem(rs.getInt("lineItemId"), productDAO.read(rs.getInt("productId")), rs.getInt("qty"));

            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }

        return l;
    }

    @Override
    public LineItem readProductLineItem(LineItem l) {

        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM PRODUCTLINEITEMS WHERE LINEITEMID= ?");
            ps.setInt(1, l.getLineItemId());
            rs = ps.executeQuery();

            if (rs.next()) {
                l = new LineItem(rs.getInt("lineItemId"), productDAO.read(rs.getInt("productId")), rs.getInt("qty"));

            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }

        return l;
    }

    @Override
    public List<LineItem> readAll() {
        List<LineItem> lineItems = new ArrayList<>();

        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM PRODUCTLINEITEMS");
            rs = ps.executeQuery();

            while (rs.next()) {

                LineItem l = new LineItem(rs.getInt("lineItemId"), productDAO.read(rs.getInt("productId")), rs.getInt("qty"));
                lineItems.add(l);

            }

        } catch (SQLException ex) {
        } finally {
            closeStreams();
        }

        return lineItems;
    }

    @Override
    public List<LineItem> readAllProductLineItem(Product p) {
        List<LineItem> lineItems = new ArrayList<>();
        LineItem l= null;
        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM PRODUCTLINEITEMS WHERE PRODUCTID=?");
            ps.setInt(1, p.getProductID());
            rs = ps.executeQuery();

            while (rs.next()) {
               

                l = new LineItem(rs.getInt("lineItemId"),productDAO.read(rs.getInt("productId")), rs.getInt("qty"));
                lineItems.add(l);

            }

        } catch (SQLException ex) {
        } finally {
            closeStreams();
        }

        return lineItems;
    }

    @Override
    public boolean update(LineItem l) {
        boolean isUpdated = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("UPDATE PRODUCTLINEITEMS SET PRODUCTID=?,QTY=? WHERE LINEITEMID=?");

            ps.setInt(1, l.getProduct().getProductID());
            ps.setInt(2, l.getQty());
            ps.setInt(3, l.getLineItemId());

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
    public boolean delete(LineItem l) {
        boolean isDeleted = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("UPDATE PRODUCTLINEITEMS SET ISACTIVE=? WHERE LINEITEMID=?");
            ps.setString(1, "N");
            ps.setInt(2, l.getLineItemId());
            ps.executeUpdate();
            isDeleted = true;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }

        return isDeleted;
    }
    
    @Override
    public LineItem readProductLineItem(Product p) {
        LineItem l = null;
        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM PRODUCTLINEITEMS WHERE PRODUCTID= ?");
            ps.setInt(1,p.getProductID());
            rs = ps.executeQuery();

            if (rs.next()) {
                l = new LineItem(rs.getInt("lineItemId"), productDAO.read(rs.getInt("productId")), rs.getInt("qty"));

            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }

        return l;
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
