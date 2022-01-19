
package za.co.bakery.domain;

/**
 *
 * @author StuartLittles
 */

public class Ingredient {
    private int ingredientID;



    private String name;
    private String nutrient;

    @Override
    public String toString() {
        return name + nutrient;
    }

 public Ingredient(String name, String nutrient) {

        this.name = name;
        this.nutrient = nutrient;
    }
    public Ingredient(String name, String nutrient, int ingredientID) {

    }

    public String getName() {
        return name;
    }

    
    public int getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(int ingredientID) {
        this.ingredientID = ingredientID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNutrient() {
        return nutrient;
    }

    public void setNutrient(String nutrient) {
        this.nutrient = nutrient;
    }
    
}

