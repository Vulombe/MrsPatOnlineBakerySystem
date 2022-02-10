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
import za.co.bakery.domain.Product;
import za.co.bakery.manager.DBPoolManagerBasic;

/**
 *
 * @author Studio13
 */
public class IngredientDAOImpl implements IngredientDAO {

    final private DBPoolManagerBasic dbpm;
    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;
   
// ************************************************************************

    public IngredientDAOImpl(DBPoolManagerBasic dbpm) {
        this.dbpm = dbpm;

    }

    //*****************add product to database*******************************
    @Override
    public boolean add(Ingredient i) {
        boolean isAdded = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("INSERT INTO INGREDIENT(ingredientId,ingredientName,nutrient,isActive) VALUES(null,?,?,null)");

            //  ps.setInt(1, p.getProductID());
            ps.setString(1, i.getName());
            ps.setString(2, i.getNutrient());

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
    public Ingredient readIngridient(String name) {
        Ingredient i = null;
        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM INGREDIENT WHERE INGREDIENTNAME= ? AND ISACTIVE=?");
            ps.setString(1, name);
            ps.setString(2, "Y");
            rs = ps.executeQuery();

            if (rs.next()) {

                i = new Ingredient(rs.getString("ingredientName"), rs.getString("nutrient"), rs.getInt("ingredientId"));

            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }

        return i;
    }

    @Override
    public List<Ingredient> readAll() {
        List<Ingredient> ingredients = new ArrayList<>();

        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM INGREDIENT WHERE  ISACTIVE=?");
            ps.setString(1, "Y");
            rs = ps.executeQuery();

            while (rs.next()) {

                Ingredient i = new Ingredient(rs.getString("ingredientName"), rs.getString("nutrient"), rs.getInt("ingredientId"));
                ingredients.add(i);

            }

        } catch (SQLException ex) {
        } finally {
            closeStreams();
        }

        return ingredients;
    }

    @Override
    public List<Product> readAllProductOfIngredient(Ingredient i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Ingredient i) {
        boolean isUpdated = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("update ingredient set IngredientName=?,nutrient=? where ingredientName=?");

            ps.setString(1, i.getName());
            ps.setString(2, i.getNutrient());
            ps.setString(3, i.getName());
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
    public boolean delete(Ingredient i) {
        boolean isDeleted = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("update ingredient set isActive=? where email=?");
            ps.setString(1, "N");
            ps.setString(2, i.getName());
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
    public Ingredient readIngridientById(int Id) {
       Ingredient i = null;
        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM INGREDIENT WHERE INGREDIENTID= ?");
            ps.setInt(1,Id);
            rs = ps.executeQuery();

            if (rs.next()) {

                i = new Ingredient(rs.getString("ingredientName"), rs.getString("nutrient"), rs.getInt("ingredientId"));

            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }

        return i;
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