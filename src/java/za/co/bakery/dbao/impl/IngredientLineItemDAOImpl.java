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
import za.co.bakery.dbao.IngredientDAO;
import za.co.bakery.dbao.IngredientLineItemDAO;
import za.co.bakery.domain.Ingredient;
import za.co.bakery.domain.IngredientItem;
import za.co.bakery.manager.DBPoolManagerBasic;

/**
 *
 * @author Studio13
 */
public class IngredientLineItemDAOImpl implements IngredientLineItemDAO {

    final private DBPoolManagerBasic dbpm;
    private Connection con = null;
    private PreparedStatement ps;
    private PreparedStatement psIsLineItemValid;
    private PreparedStatement psUpdateQty;
    private ResultSet rs;
    private IngredientDAO ingredientDAO;
// ************************************************************************

    public IngredientLineItemDAOImpl(DBPoolManagerBasic dbpm) {
        this.dbpm = dbpm;
        this.ingredientDAO= new IngredientDAOImpl(dbpm);
    }

    //*****************add product to database*******************************
    @Override
    public boolean addIgredientItem(IngredientItem it) {
        boolean isAdded = false;
        boolean exist = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("INSERT INTO INGREDIENTITEM (ingredientItemId,ingredientId,qty,ingredientName,isActive) VALUES(null,?,?,?,null)");
            psIsLineItemValid = con.prepareStatement("SELECT * FROM INGREDIENTITEM WHERE  ingredientItemId=? AND ingredientId =?");
            psUpdateQty = con.prepareStatement("UPDATE INGREDIENTITEM SET qty=? WHERE ingredientItemId=? AND ingredientId =?");

            //  ps.setInt(1, p.getProductID());
            ps.setInt(1, it.getIngredient().getIngredientID());

            it.setIngredientItemId(rs.getInt("ingredientItemId"));
            psIsLineItemValid.setInt(1, it.getIngredientItemId());
            psIsLineItemValid.setInt(2, it.getIngredient().getIngredientID());

            rs = psIsLineItemValid.executeQuery();

            if (exist = rs.next()) {
                int qty = rs.getInt("qty");
                psUpdateQty.setInt(1, it.getQty() + qty);
                psUpdateQty.setInt(2, it.getIngredientItemId());
                psUpdateQty.setInt(3, it.getIngredient().getIngredientID());

            } else {
                ps.setInt(2, it.getQty());
            }
            ps.setString(3, it.getIngredient().getName());
            psUpdateQty.executeUpdate();
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
    public IngredientItem readIngridientItem(int ingredientItemId) {

        IngredientItem it = null;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM INGREDIENTITEM WHERE ingredientItemId=?");

            ps.setInt(1, ingredientItemId);
            rs = ps.executeQuery();

            if (rs.next()) {
                it = new IngredientItem();
                it.setIngredientItemId(ingredientItemId);
                it.setIngredient(ingredientDAO.readIngridientById(rs.getInt("ingredientId")));
                it.setQty(rs.getInt("qty"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeStreams();
        }
        return it;
    }

    @Override
    public List<IngredientItem> readAll() {
        IngredientItem it = null;
        List<IngredientItem> ingredientItems = new ArrayList<>();
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM INGREDIENTITEM");
            rs = ps.executeQuery();

            while (rs.next()) {
                it = new IngredientItem();
                it.setIngredientItemId(rs.getInt("ingredientItemId"));
                it.setIngredient(ingredientDAO.readIngridientById(rs.getInt("ingredientId")));
                it.setQty(rs.getInt("qty"));
                ingredientItems.add(it);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeStreams();
        }
        return ingredientItems;
    }

    @Override
    public List<IngredientItem> readAllProductOfIngredient(Ingredient i) {
        IngredientItem it = null;
        List<IngredientItem> ingredientItems = new ArrayList<>();
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM INGREDIENTITEM WHERE INGREDIENTID=?");
            ps.setInt(1, i.getIngredientID());
            rs = ps.executeQuery();

            while (rs.next()) {
                it = new IngredientItem();
                it.setIngredientItemId(rs.getInt("ingredientItemId"));
                it.setIngredient(ingredientDAO.readIngridientById(rs.getInt(i.getIngredientID())));
                it.setQty(rs.getInt("qty"));
                ingredientItems.add(it);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeStreams();
        }
        return ingredientItems;
    }

    @Override
    public IngredientItem readIngridientItem(Ingredient i) {
        IngredientItem it = null;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM INGREDIENTITEM WHERE INGREDIENTID=?");
            ps.setInt(1, i.getIngredientID());
            rs = ps.executeQuery();

            while (rs.next()) {
                it = new IngredientItem();
                it.setIngredientItemId(rs.getInt("ingredientItemId"));
                it.setIngredient(i);
                it.setQty(rs.getInt("qty"));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeStreams();
        }
        return it;
    }

    @Override
    public boolean update(IngredientItem it) {
        boolean isUpdated = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("update ingredientitem set ingredientId=?,qty=?,ingredientName where ingredientItemId=?");

            ps.setInt(1, it.getIngredient().getIngredientID());
            ps.setInt(2, it.getQty());
            ps.setString(3, it.getIngredient().getName());
            ps.setInt(4, it.getIngredientItemId());
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
    public boolean delete(IngredientItem it) {
        boolean isDeleted = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("update ingredientitem set isActive=? where ingredientItemId=?");
            ps.setString(1, "N");
            ps.setInt(2, it.getIngredientItemId());
            ps.executeUpdate();
            isDeleted = true;
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
    // ************************************************************************

}
