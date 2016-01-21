package orders.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OrderDetail")
public class OrderDetailBean {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderDetailId;
	private int orderId;
	private String memberId;
	private String productNameTw;
	private String productNameUs;
	private int quantity;
	private int price;
	
	@ManyToOne
	@JoinColumn(
		name="ORDERID",
		referencedColumnName="ORDERID",
		insertable=false,
		updatable=false,
		nullable=false)
	private OrdersBean order;
	
	public OrdersBean getOrder() {
		return order;
	}
	public void setOrder(OrdersBean order) {
		this.order = order;
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderDetailBean [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", memberId=" + memberId
				+ ", productNameTw=" + productNameTw + ", productNameUs=" + productNameUs + ", quantity=" + quantity
				+ ", price=" + price + ", order=" + order + "]";
	}
	
	
	public OrderDetailBean(){super();}
	
	public OrderDetailBean(int orderId){
		super();
		this.orderId=orderId;
	}


	

}
