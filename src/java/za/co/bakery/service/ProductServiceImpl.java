package za.co.bakery.service;

import java.util.List;
import java.util.Objects;
import za.co.bakery.dbao.ProductDAO;
import za.co.bakery.dbao.RecipeDAO;
import za.co.bakery.dbao.UserDOA;
import za.co.bakery.dbao.impl.ProductDAOImpl;
import za.co.bakery.dbao.impl.UserDOAImpl;
import za.co.bakery.domain.Category;
import za.co.bakery.domain.Ingredient;
import za.co.bakery.domain.Product;
import za.co.bakery.domain.User;
import za.co.bakery.domain.LineItemCollection;
import za.co.bakery.domain.IngredientItem;
import za.co.bakery.domain.LineItem;
import za.co.bakery.domain.Recipe;
import za.co.bakery.manager.DBPoolManagerBasic;

/**
 *
 * @author Stuart Littles
 */
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;
    private UserDOA userDAO;
    private RecipeDAO recipeDAO;

    public ProductServiceImpl(DBPoolManagerBasic dbpm) {
        this.productDAO = new ProductDAOImpl(dbpm);
    }

    @Override
    public boolean productAdd(String name, String picture, double price, Category category, String warning, String description, int recipeID) {
        Product product = new Product(name, picture, price, category, warning, description, recipeID);
        return productDAO.add(product);
    }

    @Override
    public List<Product> getProducts(String category) {
        String r = category.toUpperCase();

        return productDAO.read(Category.valueOf(r));
    }

    @Override
    public Product getProduct(String productID) {
        int pId = Integer.parseInt(productID);

        return productDAO.read(pId);
    }

    @Override
    public Ingredient getIngredient(int ingredientID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addRecipe(String steps, String recipeName,List<IngredientItem> ingredients) {
        Recipe r = new Recipe(steps,ingredients, recipeName);
        return recipeDAO.add(r);
    }   

    @Override
    public int addToCart(String productID, String qty, LineItemCollection cart) {
        Product p = this.getProduct(productID);
        int quantity = Integer.parseInt(qty);
        cart.addProduct(p, quantity);
        return cart.getCart().size();
    }

    @Override
    public boolean productDelete(int productID) {
        return productDAO.delete(productID);
    }

    @Override
    public int editCart(String productID, String qty, LineItemCollection cart) {
        Product p = this.getProduct(productID);
        int quantity = Integer.parseInt(qty);
        cart.editCartQty(p, quantity);
        return cart.getCart().size();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.productDAO);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductServiceImpl other = (ProductServiceImpl) obj;
        if (!Objects.equals(this.productDAO, other.productDAO)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean productUpdate(int productID, String field, String update) {
        Product p = this.productDAO.read(productID);
        String f = field.toLowerCase();

        switch (f) {
            case "name":
                p.setName(update);
                break;
            case "picture":
                p.setPicture(update);
                break;
            case "price":
                p.setPrice(Double.parseDouble(update));
                break;
            case "category":
                String r = update.toUpperCase();
                p.setCategory(Category.valueOf(r));
                break;
            case "warning":
                p.setWarning(update);
                break;
            case "description":
                p.setDescription(update);
                break;
            case "recipe":
                p.setRecipe(Integer.parseInt(update));
                break;
        }

        return productDAO.update(p);
    }

    @Override
    public boolean recipeUpdate(String recipeName, String field, String update) {
        Recipe r = this.recipeDAO.read(recipeName);
        
        String
    }

}
