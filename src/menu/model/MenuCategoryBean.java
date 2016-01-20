package menu.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MenuCategory")
public class MenuCategoryBean implements java.io.Serializable
{
	@OneToMany(
			mappedBy="menuCategory",
			cascade={
					javax.persistence.CascadeType.REMOVE
			}
			)
	private Set<MenuFoodBean> menuFood;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CategoryNum;
	private String CategoryName;
	private String titleNameTw;
	private String titleNameUs;
	private String serveTime;
	
	public int getCategoryNum() {
		return CategoryNum;
	}
	public void setCategoryNum(int categoryNum) {
		CategoryNum = categoryNum;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getTitleNameTw() {
		return titleNameTw;
	}
	public void setTitleNameTw(String titleNameTw) {
		this.titleNameTw = titleNameTw;
	}
	public String getTitleNameUs() {
		return titleNameUs;
	}
	public void setTitleNameUs(String titleNameUs) {
		this.titleNameUs = titleNameUs;
	}
	public String getServeTime() {
		return serveTime;
	}
	public void setServeTime(String serveTime) {
		this.serveTime = serveTime;
	}
	@Override
	public String toString() {
		return "MenuCategoryBean [CategoryNum=" + CategoryNum + ", CategoryName=" + CategoryName + ", titleNameTw="
				+ titleNameTw + ", titleNameUs=" + titleNameUs + ", serveTime=" + serveTime + "]";
	}
	
}
