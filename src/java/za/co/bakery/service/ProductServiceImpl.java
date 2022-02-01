package za.co.bakery.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import za.co.bakery.dbao.IngredientDAO;
import za.co.bakery.dbao.ProductDAO;
import za.co.bakery.dbao.ProductLineItemDAO;
import za.co.bakery.dbao.RecipeDAO;
import za.co.bakery.dbao.UserDOA;
import za.co.bakery.dbao.impl.IngredientDAOImpl;
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

    public ProductServiceImpl(DBPoolManagerBasic dbpm) {
        this.productDAO = new ProductDAOImpl(dbpm);
        this.productLineItemDAO = new ProductLineItemDAOImpl(dbpm);
        this.recipeDAO = new RecipeDAOImpl(dbpm);
        this.ingredientDAO = new IngredientDAOImpl(dbpm);
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

//    @Override
//    public Ingredient getIngredient(int ingredientID) {
//        return ingredientDAO.readIngridientById(ingredientID);
//    }
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
    public boolean productDelete(int productID) {
        return productDAO.delete(productID);
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
                if(li.getQty()<1){
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
    public boolean productUpdate(int productID, String field, String update) {

        Product p = productDAO.read(productID);
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
    public boolean recipeUpdate(int ID, String steps,
            List<IngredientItem> ingredients, String recipeName
    ) {
        Recipe r = new Recipe(ID, steps, ingredients, recipeName);
//        return recipeDAO.update(r);
        return true;
    }

    @Override
    public int getCartSize(LineItemCollection cart) {
        return cart.size();
    }

}
