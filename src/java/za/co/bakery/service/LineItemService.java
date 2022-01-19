package za.co.bakery.service;

import java.util.List;
import za.co.bakery.domain.Category;
import za.co.bakery.domain.IngredientItem;
import za.co.bakery.domain.LineItem;

/**
 *
 * @author Stuart Littles
 */
public interface LineItemService {
   List<LineItem> stock(Category choice);
   List<LineItem> order();
   List<IngredientItem> ingredientStock();
   LineItem createLineItem(int productID, int qty);
   
}
