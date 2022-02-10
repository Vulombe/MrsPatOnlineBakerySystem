
package za.co.bakery.service;

import java.util.ArrayList;
import za.co.bakery.domain.Category;
import za.co.bakery.domain.Product;

/**
 *
 * @author StuartLittles
 */
public interface ProductViewService {
    ArrayList<Product> getProduct(Category choice);
}
