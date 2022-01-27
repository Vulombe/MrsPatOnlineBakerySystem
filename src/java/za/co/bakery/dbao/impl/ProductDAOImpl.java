package za.co.bakery.dbao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import za.co.bakery.dbao.ProductDAO;
import za.co.bakery.domain.Category;
import za.co.bakery.domain.Product;
import za.co.bakery.domain.Recipe;
import za.co.bakery.domain.User;
import za.co.bakery.manager.DBPoolManagerBasic;

/**
 *
 * @author Stuart Littles
 */
public class ProductDAOImpl implements ProductDAO {

    final private DBPoolManagerBasic dbpm;
    private Connection con = null;
    private PreparedStatement ps;
    private ResultSet rs;
// ************************************************************************

    public ProductDAOImpl(DBPoolManagerBasic dbpm) {
        this.dbpm = dbpm;
    }

    //*****************add product to database*******************************
    public boolean add(Product p) {
        boolean isAdded = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("INSERT INTO PRODUCT(productId,Name,picture,price,"
                    + "Category, warning,description, recipeId) VALUES(null,?,?,?,?,?,?,?)");

            //  ps.setInt(1, p.getProductID());
            ps.setString(1, p.getName());
            ps.setString(2, p.getPicture());
            ps.setDouble(3, p.getPrice());
            ps.setString(4, p.getCategory().toString().toLowerCase());
            ps.setString(5, p.getWarning());
            ps.setString(6, p.getDescription());
            ps.setInt(7, p.getRecipeID());

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
//****************read product by productId**********************

    @Override
    public Product read(int Id) {
        Product p = null;
        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM PRODUCT WHERE PRODUCTID= ?");
            ps.setInt(1, Id);
            rs = ps.executeQuery();

            if (rs.next()) {

                String cat = rs.getString("CATEGORY");

                if (cat.equalsIgnoreCase("cookies")) {
                    p = new Product(Id, rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.COOKIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                } else if (cat.equalsIgnoreCase("cakes")) {
                    p = new Product(Id, rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.CAKES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                } else if (cat.equalsIgnoreCase("cupcakes")) {
                    p = new Product(Id, rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.CUPCAKES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                } else if (cat.equalsIgnoreCase("fresh_bread")) {
                    p = new Product(Id, rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.FRESH_BREAD, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                } else if (cat.equalsIgnoreCase("pastries")) {
                    p = new Product(Id, rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.PASTRIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                } else if (cat.equalsIgnoreCase("pies")) {
                    p = new Product(Id, rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.PIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                } else if (cat.equalsIgnoreCase("brownies")) {
                    p = new Product(Id, rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.BROWNIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));

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
    public List<Product> read() {
        List<Product> products = new ArrayList<>();

        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM PRODUCT");
            rs = ps.executeQuery();

            while (rs.next()) {

                String cat = rs.getString("CATEGORY");

                if (cat.equalsIgnoreCase("cookies")) {
                    Product p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.COOKIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                    products.add(p);
                } else if (cat.equalsIgnoreCase("cakes")) {
                    Product p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.CAKES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                    products.add(p);
                } else if (cat.equalsIgnoreCase("cupcakes")) {
                    Product p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.CUPCAKES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                    products.add(p);
                } else if (cat.equalsIgnoreCase("fresh_bread")) {
                    Product p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.FRESH_BREAD, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                    products.add(p);
                } else if (cat.equalsIgnoreCase("pastries")) {
                    Product p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.PASTRIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                    products.add(p);
                } else if (cat.equalsIgnoreCase("pies")) {
                    Product p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.PIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                    products.add(p);
                } else if (cat.equalsIgnoreCase("brownies")) {
                    Product p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), Category.BROWNIES, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
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
    public List<Product> read(Product p) {
        List<Product> products = new ArrayList<>();

        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("SELECT * FROM PRODUCT WHERE PRODUCTID= ?");
            rs = ps.executeQuery();

            while (rs.next()) {

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
    public List<Product> read(Category c) {
        List<Product> products = new ArrayList<>();

        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("SELECT * FROM PRODUCT WHERE CATEGORY=?");
            ps.setString(1, c.toString().toLowerCase());
            rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product(rs.getInt("PRODUCTID"), rs.getString("NAME"), rs.getString("PICTURE"), rs.getDouble("PRICE"), c, rs.getString("WARNING"), rs.getString("DESCRIPTION"), rs.getInt("RECIPEID"));
                products.add(p);

            }

        } catch (SQLException ex) {
        } finally {
            closeStreams();
        }
        return products;
    }
//***************update product in the database*******************************

    @Override
    public boolean update(Product p) {
        boolean isUpdated = false;
        try {
            con = dbpm.getConnection();

            ps = con.prepareStatement("update Product set Name=?,picture=?,price=?,Category=?,warning=?,description=?,recipeId=? where productId=?");

            ps.setString(1, p.getName());
            ps.setString(2, p.getPicture());
            ps.setDouble(3, p.getPrice());
            ps.setString(4, p.getCategory().toString().toLowerCase());
            ps.setString(5, p.getWarning());
            ps.setString(6, p.getDescription());
            ps.setInt(7, p.getRecipeID());
            ps.setInt(8, p.getProductID());

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

    //**************delete product in the database**************************
    @Override
    public boolean delete(int productId) {

        boolean isDeleted = false;
        try {
            con = dbpm.getConnection();
            ps = con.prepareStatement("update Product set isActive=? where productId=?");
            ps.setString(1, "N");
            ps.setInt(2, productId);
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
    public Recipe readRecipe(Product p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //    
    //    @Override
    //    public List<Product> read(Category choice) {
    //        PreparedStatement statement;
    //        List<Product> choices = null;
    //        try {
    //
    //            ResultSet rs = statement.executeQuery();
    //            while (rs.next()) {
    //                choices.add(new Product(rs.getInt("ProductID"),
    //                        rs.getString("name"),
    //                        rs.getString("picture"),
    //                        rs.getDouble("price"),
    //                        (Category) rs.getObject("category"),
    //                        rs.getString("warning"),
    //                        rs.getString("description"),
    //                        rs.getInt("recipe")));
    //            }
    //        } catch (SQLException ex) {
    //            System.out.println("Error: " + ex.getMessage());
    //        }
    //        return choices;
    //    }
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
