package products.model;

import java.util.*;
import java.io.Serializable;
import java.text.NumberFormat;

public class Cart implements Serializable {

    @Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}

	private List<LineItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void setItems(List<LineItem> lineItems) {
        items = lineItems;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(LineItem item) {
        //If the item already exists in the cart, only the quantity is changed.
    		int productId = item.getProduct().getProductId();
    	
        int quantity = item.getQuantity();
        for (LineItem lineItem : items) 
        {
            if (lineItem.getProduct().getProductId() == productId)
            {
            	lineItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(LineItem item) {
        int code = item.getProduct().getProductId();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getProductId() == code) {
                items.remove(i);
                return;
            }
        }
    }
    
    public int getTotal(){
    	int total = 0;
    	for(LineItem item : items){
    		total = total + item.getTotal();
    		System.out.println("1-"+total);
    	}
		return total;
    }
    
    public String getTotalFormat(){
    	int total = this.getTotal();
    	System.out.println("2-"+total);
    	NumberFormat currency = NumberFormat.getCurrencyInstance();
    	String formatTotal = currency.format(total);
    	return formatTotal;
    }
    
}