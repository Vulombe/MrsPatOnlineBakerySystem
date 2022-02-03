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
import za.co.bakery.dbao.RecipeDAO;
import za.co.bakery.domain.Category;
import za.co.bakery.domain.Ingredient;
import za.co.bakery.domain.IngredientItem;
import za.co.bakery.domain.Product;
import za.co.bakery.domain.Recipe;
import za.co.bakery.manager.DBPoolManagerBasic;

/**
 *
 * @author Studio13
 */
public class RecipeDAOImpl implements RecipeDAO {

    final private DBPoolManagerBasic dbpm;
    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;
// ************************************************************************

    public RecipeDAOImpl(DBPoolManagerBasic dbpm) {
        this.dbpm = dbpm;
    }

    //*****************add product to database*******************************
    @Override
    public boolean add(Recipe r) {

        boolean isAdded = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("INSERT INTO RECIPE(recipeId,recipeName,ingredients,steps,"
                    + "isActive) VALUES(null,?,?,?,null)");

            //  ps.setInt(1, p.getProductID());
            ps.setString(1, r.getRecipeName());
            List<IngredientItem> ingredientItems = r.getIngredients();
            String ingreItems = "";
            for (IngredientItem i : ingredientItems) {
                ingreItems += i.getIngredientItemId() + ",";
            }
            ps.setString(2, ingreItems.substring(0, ingreItems.length() - 1).trim());
            ps.setString(3, r.getSteps());
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
    public Recipe read(String name) {
        Recipe r = null;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM RECIPE WHERE RECIPENAME=?");
            ps.setString(1, name);
            rs = ps.executeQuery();

            if (rs.next()) {
                r = new Recipe();
                r.setRecipeID(rs.getInt("recipeId"));
                r.setRecipeName(rs.getString("recipeName"));
                String ingreItem = rs.getString("ingredients");
                String[] ingreItemsstring = ingreItem.split(",");
                List<IngredientItem> ingreItemsStringList = new ArrayList();
                for (String s : ingreItemsstring) {
                    IngredientItem it = new IngredientItem();
                    it.setIngredientItemId(Integer.parseInt(s));
                    ingreItemsStringList.add(it);
                }
                r.setIngredients(ingreItemsStringList);
                r.setSteps(rs.getString("Steps"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeStreams();
        }
        return r;
    }

    @Override
    public Product read(Recipe r) {
        Product p = null;

        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM PRODUCT WHERE RECIPEID= ?");
            ps.setInt(1, r.getRecipeID());
            rs = ps.executeQuery();

            if (rs.next()) {

                String cat = rs.getString("CATEGORY");

                if (cat.equalsIgnoreCase("cookies")) {
                    p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.COOKIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                } else if (cat.equalsIgnoreCase("cakes")) {
                    p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.CAKES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                } else if (cat.equalsIgnoreCase("cupcakes")) {
                    p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.CUPCAKES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                } else if (cat.equalsIgnoreCase("fresh_bread")) {
                    p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.FRESH_BREAD, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                } else if (cat.equalsIgnoreCase("pastries")) {
                    p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.PASTRIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                } else if (cat.equalsIgnoreCase("pies")) {
                    p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.PIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                } else if (cat.equalsIgnoreCase("brownies")) {
                    p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.BROWNIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));

                }

            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            closeStreams();
        }

        return p;
    }

    @Override
    public List<Recipe> readAll() {
        List<Recipe> recipes = new ArrayList<>();

        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM RECIPE");
            rs = ps.executeQuery();

            while (rs.next()) {
                Recipe r = new Recipe();
                r.setRecipeID(rs.getInt("recipeId"));
                r.setRecipeName(rs.getString("recipeName"));
                String ingreItem = rs.getString("ingredients");
                String[] ingreItemsstring = ingreItem.split(",");
                List<IngredientItem> ingreItemsStringList = new ArrayList();
                for (String s : ingreItemsstring) {
                    IngredientItem it = new IngredientItem();
                    it.setIngredientItemId(Integer.parseInt(s));
                    ingreItemsStringList.add(it);
                }
                r.setIngredients(ingreItemsStringList);
                r.setSteps(rs.getString("Steps"));
                recipes.add(r);
            }

        } catch (SQLException ex) {
        } finally {
            closeStreams();
        }

        return recipes;
    }

    @Override
    public List<Product> readProductOfRecipe(Recipe r) {
        List<Product> products = new ArrayList<>();

        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM PRODUCT WHERE RECIPEID= ?");
            ps.setInt(1, r.getRecipeID());
            rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product();

                String cat = rs.getString("CATEGORY");

                if (cat.equalsIgnoreCase("cookies")) {
                    p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.COOKIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                    products.add(p);
                } else if (cat.equalsIgnoreCase("cakes")) {
                    p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.CAKES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                    products.add(p);
                } else if (cat.equalsIgnoreCase("cupcakes")) {
                    p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.CUPCAKES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                    products.add(p);
                } else if (cat.equalsIgnoreCase("fresh_bread")) {
                    p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.FRESH_BREAD, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                    products.add(p);
                } else if (cat.equalsIgnoreCase("pastries")) {
                    p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.PASTRIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                    products.add(p);
                } else if (cat.equalsIgnoreCase("pies")) {
                    p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.PIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                    products.add(p);
                } else if (cat.equalsIgnoreCase("brownies")) {
                    p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.BROWNIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                    products.add(p);
                }

            }

        } catch (SQLException ex) {
        } finally {
            closeStreams();
        }

        return products;
    }

    @Override
    public boolean update(Recipe r) {
        boolean isUpdated = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("update recipe set recipeName=?,ingredients=?,steps=? where recipeId=?");

            ps.setString(1, r.getRecipeName());

            List<IngredientItem> ingredientItems = r.getIngredients();
            String ingreItems = "";
            for (IngredientItem i : ingredientItems) {
                ingreItems += i.getIngredientItemId() + ",";
            }
            ps.setString(2, ingreItems.substring(0, ingreItems.length() - 1).trim());
            ps.setString(3, r.getSteps());
            ps.setInt(4, r.getRecipeID());
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
    public boolean delete(Recipe r) {
        boolean isDeleted = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("update Recipe set isActive=? where recipeId=?");
            ps.setString(1, "N");
            ps.setInt(2, r.getRecipeID());
            if (ps.executeUpdate() > 0) {
                isDeleted = true;
            }
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
