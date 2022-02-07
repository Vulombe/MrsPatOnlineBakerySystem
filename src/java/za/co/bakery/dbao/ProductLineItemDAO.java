/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.bakery.dbao;

import java.util.List;
import za.co.bakery.domain.LineItem;

import za.co.bakery.domain.Product;

/**
 *
 * @author Studio13
 */
public interface ProductLineItemDAO {

    public boolean addProductLineItem(LineItem li);

    public LineItem readProductLineItem(int lineItemId);

    public LineItem readProductLineItem(LineItem l);

    public LineItem readProductLineItem(Product p);

    public List<LineItem> readAll();

    public List<LineItem> readAllProductLineItem(Product p);

    public boolean update(LineItem l);

    public boolean delete(LineItem l);
}
