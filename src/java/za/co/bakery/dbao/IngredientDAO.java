/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.dbao;

import java.util.List;
import za.co.bakery.domain.Ingredient;
import za.co.bakery.domain.Product;

/**
 *
 * @author Studio13
 */
public interface IngredientDAO {
   public boolean add(Ingredient i);
    public Ingredient readIngridient(String name);
     public Ingredient readIngridientById(int Id);
    public List<Ingredient> readAll();
    public List<Product> readAllProductOfIngredient(Ingredient i);
    public boolean update(Ingredient i);
    public boolean delete(Ingredient i);
   
       
}
