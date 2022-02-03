package za.co.bakery.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Stuart Littles
 */
public class Stock {
    private List<LineItem> stockCount = null;
    private Calendar date = null;
    

    public Stock(Calendar date) {
        this.date = date;
    }

    public List<LineItem> getStockCount() {
        return stockCount;
    }

    public void setStockCount(List<LineItem> stockCount) {
        this.stockCount = stockCount;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
    
//    public List<?> dayReport(Calendar date){
//        date.
//    }
    
//    public List<MonthlyStock> monthReport(Date date){
//        
//    }
}
