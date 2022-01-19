package za.co.bakery.service;

import java.util.List;
import za.co.bakery.domain.Category;
import za.co.bakery.domain.Ingredient;
import za.co.bakery.domain.Product;

/**
 *
 * @author Stuart Littles
 */
public interface ProductService {
    boolean productAdd(String name, String picture, double price, Category category, String warning, String description, int recipeID);
    List<Product> getProducts(String category);
    Product getProduct(String productID);
    Ingredient getIngredient(int ingredientID);
    boolean productDelete(int productID, String name, String picture, double price, Category category, String warning, String description, int recipeID);
}
