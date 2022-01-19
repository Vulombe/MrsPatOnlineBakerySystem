
package za.co.bakery.domain;

/**
 *
 * @author StuartLittles
 */

public class IngredientItem{

    private int qty;
    private Ingredient ingredient;

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public IngredientItem(int qty) {
        this.qty = qty;
        
    }

    @Override
    public String toString() {
        return ingredient.getName() + qty;
    }
    
}
