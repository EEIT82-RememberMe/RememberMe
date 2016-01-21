package products.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class ProductBean implements Serializable
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	private String productNameTw;
	private String productNameUs;
	private String productImage;
	private int productPrice;
	private String productDescription;
	private String remarks;
	private int stock;
	private java.util.Date createDate;
	private java.util.Date updateDate;

	public ProductBean() {
		super();
	}
	
	public ProductBean(String productNameTw, String productNameUs,String productDescription,
			           String remarks, String productImage, int productPrice, int stock, Date updateDate)
	{
		super();
		this.productNameTw = productNameTw;
		this.productNameUs = productNameUs;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.remarks = remarks;
		this.stock = stock;
		this.updateDate = updateDate;
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductNameTw() {
		return productNameTw;
	}
	public void setProductNameTw(String productNameTw) {
		this.productNameTw = productNameTw;
	}
	public String getProductNameUs() {
		return productNameUs;
	}
	public void setProductNameUs(String productNameUs) {
		this.productNameUs = productNameUs;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "ProductBean [productId=" + productId + "productNameTw="
				+ productNameTw + ", productNameUs=" + productNameUs + ", productImage=" + productImage
				+ ", productPrice=" + productPrice + ", productDescription=" + productDescription + ", remarks="
				+ remarks + ", stock=" + stock + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
