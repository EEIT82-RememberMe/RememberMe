package menu.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MenuFood")
public class MenuFoodBean {
	@ManyToOne
	@JoinColumn(
			name="categoryNum",
		    referencedColumnName="categoryNum",
		    insertable=false,updatable=false
			)
	private MenuCategoryBean menuCategory;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int foodId;
	private int categoryNum;
	private String categoryName;
	private String foodNameTw;
	private String foodNameUs;
	private String textDecoration;
	private String info;
	private String temperature;
	private String price;
	private java.util.Date createDate;
	private java.util.Date updateDate;
	
	public MenuFoodBean() {
		super();
	}
	public MenuFoodBean(String foodNameTw, String foodNameUs, String textDecoration, String info,
			String temperature, String price, Timestamp updateDate) 
	{
		super();
		this.foodNameTw = foodNameTw;
		this.foodNameUs = foodNameUs;
		this.textDecoration = textDecoration;
		this.info = info;
		this.temperature = temperature;
		this.price = price;
		this.updateDate = updateDate;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getCategoryNum() {
		return categoryNum;
	}
	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getFoodNameTw() {
		return foodNameTw;
	}
	public void setFoodNameTw(String foodNameTw) {
		this.foodNameTw = foodNameTw;
	}
	public String getFoodNameUs() {
		return foodNameUs;
	}
	public void setFoodNameUs(String foodNameUs) {
		this.foodNameUs = foodNameUs;
	}
	public String getTextDecoration() {
		return textDecoration;
	}
	public void setTextDecoration(String textDecoration) {
		this.textDecoration = textDecoration;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
		return "MenuFoodBean [foodId=" + foodId + ", categoryNum=" + categoryNum + ", categoryName=" + categoryName
				+ ", foodNameTw=" + foodNameTw + ", foodNameUs=" + foodNameUs + ", textDecoration=" + textDecoration
				+ ", info=" + info + ", temperature=" + temperature + ", price=" + price + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}
	
}
