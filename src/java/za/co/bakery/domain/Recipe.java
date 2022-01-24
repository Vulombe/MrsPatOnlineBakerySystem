
package za.co.bakery.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author StuartLittle
 */

public class Recipe {


    private String steps;
    private List<IngredientItem> ingredients;
    private String recipeName;
    private int recipeID;

    public Recipe(String steps, List<IngredientItem> ingredients, String recipeName) {
        this.steps = steps;
        this.ingredients = ingredients;
        this.recipeName = recipeName;
    }

    public Recipe() {
     
    }
    
    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }
   

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public List<IngredientItem> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientItem> ingredients) {
        this.ingredients = ingredients;
    }
    
    public void addIngredients(IngredientItem e){
        this.getIngredients().add(e);
    }

    @Override
    public String toString() {
        return recipeName;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }
    
}