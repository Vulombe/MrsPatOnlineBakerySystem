package za.co.bakery.dbao;

import java.util.List;
import za.co.bakery.domain.Category;
import za.co.bakery.domain.Product;

/**
 *
 * @author Stuart Littles
 */
public interface ProductDAO {

    public boolean add(Product p);
    public Product read(int id);
    public List<Product> read();
     public List<Product> read(Product p);
    public List<Product> read(Category c);
    public void update(Product p);
    public void delete(Product p);
    

//    boolean ProductAdd(String name, String picture, double price, Category category, String warning, String description, int recipeID);
//    List<Product> getProduct(Category choice);
    // public List<Product> read(Category c);
}
