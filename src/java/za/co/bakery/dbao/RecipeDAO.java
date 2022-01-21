/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.dbao;

import java.util.List;
import za.co.bakery.domain.Product;
import za.co.bakery.domain.Recipe;

/**
 *
 * @author Studio13
 */
public interface RecipeDAO {

    public boolean add(Recipe r);
    public Recipe read(String name);
    public Product read(Recipe r);
    public List<Recipe> readAll();
    public boolean update(Product p);
    public boolean delete(Product p);
}
