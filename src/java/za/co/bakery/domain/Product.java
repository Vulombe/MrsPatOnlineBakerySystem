package za.co.bakery.domain;

/**
 *
 * @author StuartLittles
 */
public class Product {
    private int productID;
    private String name;
    private String picture;
    private double price;
    private Category category;
    private String warning;
    private String description;
    private int recipeID;

    public Product(){}
    
    public Product(String name, String picture, double price, Category category, String warning, String description, int recipeID) {
        this.picture = picture;
        this.price = price;
        this.category = category;
        this.warning = warning;
        this.description = description;
        this.recipeID = recipeID;
        this.productID = productID;
        this.name = name;
    }
    
    public Product( int productID, String name, String picture, double price, Category category, String warning, String description, int recipeID) {
        this.picture = picture;
        this.price = price;
        this.category = category;
        this.warning = warning;
        this.description = description;
        this.recipeID = recipeID;
        this.productID = productID;
        this.name = name;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRecipe() {
        return recipeID;
    }

    public void setRecipe(int recipe) {
        this.recipeID = recipe;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.productID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.productID != other.productID) {
            return false;
        }
        return true;
    }
    
    
}
