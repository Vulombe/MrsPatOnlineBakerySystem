package za.co.bakery.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import za.co.bakery.dbao.IngredientDAO;
import za.co.bakery.dbao.IngredientLineItemDAO;
import za.co.bakery.dbao.ProductDAO;
import za.co.bakery.dbao.ProductLineItemDAO;
import za.co.bakery.dbao.RecipeDAO;
import za.co.bakery.dbao.UserDOA;
import za.co.bakery.dbao.impl.IngredientDAOImpl;
import za.co.bakery.dbao.impl.IngredientLineItemDAOImpl;
import za.co.bakery.dbao.impl.ProductDAOImpl;
import za.co.bakery.dbao.impl.ProductLineItemDAOImpl;
import za.co.bakery.dbao.impl.RecipeDAOImpl;
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
    private IngredientDAO ingredientDAO;
    private ProductLineItemDAO productLineItemDAO;
    private IngredientLineItemDAO ingreditentLineItemDAO;

    public ProductServiceImpl(DBPoolManagerBasic dbpm) {
        this.productDAO = new ProductDAOImpl(dbpm);
        this.productLineItemDAO = new ProductLineItemDAOImpl(dbpm);
        this.recipeDAO = new RecipeDAOImpl(dbpm);
        this.ingredientDAO = new IngredientDAOImpl(dbpm);
        ingreditentLineItemDAO = new IngredientLineItemDAOImpl(dbpm);
    }

    @Override
    public boolean productAdd(String name, String picture, String price, Category category, String warning, String description, String recipeID) {
        if (name.isEmpty()) {
            name = "N/A";
        }
        if (picture.isEmpty()) {
            picture = "https://i1.sndcdn.com/avatars-BZjdypYRINkEoQBe-s2icjg-t500x500.jpg";
        }
        double p = 0;
        try {
            p = Double.parseDouble(price);
        } catch (NumberFormatException nfe) {

        }
        if (p < 1.0) {
            p = 1.0;
        }

        if (warning.isEmpty()) {
            warning = "radio-active";
        }

        if (description.isEmpty()) {
            description = "Mostly sugar flour and eggs";
        }
        int recId = 0;
        try {
            recId = Integer.parseInt(recipeID);
        } catch (NumberFormatException nfe) {

        }
        if (recId < 1) {
            recId = 1;
        }

        Product product = new Product(name, picture, p, category, warning, description, recId);
        return productDAO.add(product);
    }

    @Override
    public List<Product> getProducts(String category) {
        String r = category.toUpperCase();

        return productDAO.read(Category.valueOf(r));
    }

    @Override
    public Product getProduct(String productID) {

        int pId = 0;
        try {
            pId = Integer.parseInt(productID);
        } catch (NumberFormatException nfe) {
            return null;
        }

        return productDAO.read(pId);
    }

    @Override
    public Ingredient getIngredient(String ingredientID) {
        int ID = 0;
        try {
            ID = Integer.parseInt(ingredientID);
        } catch (NumberFormatException nfe) {
            return null;
        }

        return ingredientDAO.readIngridientById(ID);
    }

    @Override
    public boolean addRecipe(String steps, String recipeName, List<IngredientItem> ingredients) {
        Recipe r = new Recipe(steps, ingredients, recipeName);
        return recipeDAO.add(r);
    }

    @Override
    public int addToCart(String productID, String qty, LineItemCollection cart) {
        boolean check = false;
        int quantity = 0;
        try {
            quantity = Integer.parseInt(qty);
        } catch (NumberFormatException nfe) {
            return -1;
        }
        int prodId = 0;
        try {
            prodId = Integer.parseInt(productID);
        } catch (NumberFormatException nfe) {
            return -2;
        }
        for (LineItem li : cart.getCart()) {
            if (li.getProduct().getProductID() == prodId) {
                li.setQty(li.getQty() + quantity);
                check = true;
                break;
            }
        }
        if (!check) {
            cart.addProduct(this.getProduct(productID), quantity);
        }
        return cart.getCart().size();
    }

    @Override
    public boolean productDelete(String productID) {
        int prodId = 0;
        try {
            prodId = Integer.parseInt(productID);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return productDAO.delete(prodId);
    }

    @Override
    public int editCart(String productID, String qty, LineItemCollection cart) {
        int quantity = 0;
        try {
            quantity = Integer.parseInt(qty);
        } catch (NumberFormatException nfe) {
            return -1;
        }
        int prodId = 0;
        try {
            prodId = Integer.parseInt(productID);
        } catch (NumberFormatException nfe) {
            return -2;
        }
        for (LineItem li : cart.getCart()) {
            if (li.getProduct().getProductID() == prodId) {
                li.setQty(li.getQty() - quantity);
                if (li.getQty() < 1) {
                    cart.getCart().remove(li);
                }
                break;
            }
        }
        return cart.getCart().size();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.productDAO);
        return hash;
    }

    @Override
    public boolean equals(Object obj
    ) {
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
    public boolean productUpdate(String productID, String field, String update) {
        int prodId = 0;
        try {
            prodId = Integer.parseInt(productID);
        } catch (NumberFormatException nfe) {
            return false;
        }

        Product p = productDAO.read(prodId);

        if (field.isEmpty()) {
            field = "name";
        }
        if (update.isEmpty()) {
            update = "Oops";
        }

        String f = field.toLowerCase();
        double price = 0.0;
        switch (f) {
            case "name":
                p.setName(update);
                break;
            case "picture":
                p.setPicture(update);
                break;
            case "price":
                try {
                price = Double.parseDouble(update);
            } catch (NumberFormatException nfe) {
                return false;
            }
            p.setPrice(price);
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
    public boolean recipeUpdate(String ID, String steps, List<IngredientItem> ingredients, String recipeName) {

        int prodId = 0;
        try {
            prodId = Integer.parseInt(ID);
        } catch (NumberFormatException nfe) {
            return false;
        }
        Recipe r = new Recipe(prodId, steps, ingredients, recipeName);
        return recipeDAO.update(r);

    }

    @Override
    public int getCartSize(LineItemCollection cart) {
        return cart.size();
    }

    @Override
    public boolean delRecipe(String name) {
        Recipe r = recipeDAO.read(name);

        return recipeDAO.delete(r);
    }

    @Override
    public boolean addIngredient(String name, String nutrient) {

        if (name.isEmpty()) {
            name = "flour";
        }

        if (nutrient.isEmpty()) {
            nutrient = "15g of gluten per kg";
        }
        Ingredient i = new Ingredient(name, nutrient);

        return ingredientDAO.add(i);
    }

    @Override
    public boolean editIngredient(String name, String nutrient, String ingredientID) {

        int quantity = 0;
        try {
            quantity = Integer.parseInt(ingredientID);
        } catch (NumberFormatException nfe) {
            return false;
        }
        if (name.isEmpty()) {
            name = "flour";
        }

        if (nutrient.isEmpty()) {
            nutrient = "15g of gluten per kg";
        }

        Ingredient i = new Ingredient(name, nutrient, quantity);

        return ingredientDAO.update(i);
    }

    @Override
    public boolean delIngredient(String ingredientID) {
        int prodId = 0;
        try {
            prodId = Integer.parseInt(ingredientID);
        } catch (NumberFormatException nfe) {
            return false;
        }
        Ingredient i = ingredientDAO.readIngridientById(prodId);

        return ingredientDAO.delete(i);
    }

    @Override
    public List<Ingredient> getIngredients() {
        return ingredientDAO.readAll();
    }

    @Override
    public List<Recipe> getRecipes() {
        return recipeDAO.readAll();
    }

    @Override
    public List<Product> getAllProducts() {
        return productDAO.read();
    }

}
