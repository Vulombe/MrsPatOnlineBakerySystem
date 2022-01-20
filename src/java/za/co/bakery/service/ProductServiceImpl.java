package za.co.bakery.service;

import java.util.List;
import java.util.Objects;
import za.co.bakery.dbao.ProductDAO;
import za.co.bakery.dbao.impl.ProductDAOImpl;
import za.co.bakery.domain.Category;
import za.co.bakery.domain.Ingredient;
import za.co.bakery.domain.Product;
import za.co.bakery.domain.User;
import za.co.bakery.domain.Cart;
import za.co.bakery.domain.LineItem;
import za.co.bakery.manager.DBPoolManagerBasic;

/**
 *
 * @author Stuart Littles
 */
public class ProductServiceImpl implements ProductService{
    private ProductDAO productDAO;


    public ProductServiceImpl(DBPoolManagerBasic dbpm) {
        this.productDAO = new ProductDAOImpl(dbpm);
    }

    @Override
    public boolean productAdd(String name, String picture, double price, Category category, String warning, String description, int recipeID) {
        Product product = new Product(name,picture,price,category,warning,description,recipeID);
        return productDAO.add(product);
    }

    @Override
    public List<Product> getProducts(String category) {
        String r = category.toUpperCase();
        
        if(r == null || r.isEmpty()){
            r = "0";
        }
        
        if(r.equalsIgnoreCase("0")){
 //           return error message
        }
        return productDAO.read(Category.valueOf(r));
    }

    @Override
    public Product getProduct(String productID) {
        int pId = Integer.parseInt(productID);
        
        return productDAO.read(pId);
    }

    @Override
    public Ingredient getIngredient(int ingredientID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addRecipe(String Steps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int addToCart(String productID, String qty, User user){
        Product p = this.getProduct(productID);
        int quantity = Integer.parseInt(qty);
        Cart userCart = Cart.cart(user);
        userCart.addProduct(p, quantity);
        return userCart.getCart().size();
    }

    @Override
    public boolean productDelete(int productID) {
        return productDAO.delete(productID);
    }

    @Override
    public int editCart(String productID, String qty, User user) {
        Product p = this.getProduct(productID);
        int quantity = Integer.parseInt(qty);
        Cart userCart = Cart.cart(user);
        userCart.editCart(p, quantity);
        return userCart.getCart().size();
    }

    @Override
    public List<LineItem> getCart(User user) {
        Cart userCart = Cart.cart(user);
        
        return userCart.getCart();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.productDAO);
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
        final ProductServiceImpl other = (ProductServiceImpl) obj;
        if (!Objects.equals(this.productDAO, other.productDAO)) {
            return false;
        }
        return true;
    }

    


    
}
