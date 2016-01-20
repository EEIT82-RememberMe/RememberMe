package products.model;

import java.text.NumberFormat;
import java.io.Serializable;

public class LineItem implements Serializable {
    
	private Long lineItemId;
    private ProductBean product;
    private int quantity = 0;
    private int total = 0;

    public LineItem() {
    }

    public Long getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(Long lineItemId) {
        this.lineItemId = lineItemId;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public ProductBean getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    public int getTotal() {
		return total;
	}

	public void setTotal(ProductBean product,int quantity) {
		this.total = product.getProductPrice() * quantity;
	}
    
	public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }

	@Override
	public String toString() {
		return "LineItem [lineItemId=" + lineItemId + ", product=" + product + ", quantity=" + quantity + ", total="
				+ total + "]";
	}
    
}