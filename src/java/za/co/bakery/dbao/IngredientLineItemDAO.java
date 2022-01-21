/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.dbao;

import java.util.List;
import za.co.bakery.domain.IngredientItem;

/**
 *
 * @author Studio13
 */
public interface IngredientLineItemDAO {
    public boolean addIgredientItem(IngredientItem it); 
    public IngredientItem readIngridientItem(String name);
    public IngredientItem readIngridientItem(IngredientItem it);
    public List<IngredientItem> readAll();
    public List<IngredientItem> readAllProductOfIngredient(String name);
    public boolean update(IngredientItem it);
    public boolean delete(IngredientItem it);
}
