package za.co.bakery.service;

import java.util.List;
import za.co.bakery.domain.LineItemCollection;
import za.co.bakery.domain.Category;
import za.co.bakery.domain.Ingredient;
import za.co.bakery.domain.IngredientItem;
import za.co.bakery.domain.LineItem;
import za.co.bakery.domain.Product;
import za.co.bakery.domain.User;

/**
 *
 * @author Stuart Littles
 */
public interface ProductService {
    public boolean productAdd(String name, String picture, double price, Category category, String warning, String description, int recipeID);
    public List<Product> getProducts(String category);
    public Product getProduct(String productID);
    public boolean productDelete(String productID);
    public boolean productUpdate(String productID, String field, String update);
    public boolean recipeUpdate(String ID, String steps, List<IngredientItem> ingredients, String recipeName);
    public boolean addRecipe(String steps, String recipeName, List<IngredientItem> ingredients);
    public boolean delRecipe(String name);
    public int addToCart(String productID, String qty, LineItemCollection cart);
    public int editCart(String productID, String qty, LineItemCollection cart);
    public int getCartSize(LineItemCollection cart); 
    public Ingredient getIngredient(String ingredientID);
    public boolean addIngredient(String name, String nutrient);
    public boolean editIngredient(String name, String nutrient, String ingredientID);
    public boolean delIngredient(String ingredientID);
    
}
