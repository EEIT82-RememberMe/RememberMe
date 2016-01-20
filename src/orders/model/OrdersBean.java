package orders.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Orders")
public class OrdersBean {
	@Id 
	private int orderId;
	private String memberId;
	private String phone;
	private String email;
	private String sendAddress;
	private String receiveName;
	private int totalQuantity;
	private int totalPrice;
	private java.util.Date orderDate;
	private String payMethod;
	private java.util.Date payDate;
	private int transportPrice;
	private java.util.Date shippedDate;
	private String remark;
	private String ordersStatus;
	
	@OneToMany(
		mappedBy="order",
		cascade={CascadeType.ALL})
	private Set<OrderDetailBean> orderDetails;
	
	public Set<OrderDetailBean> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Set<OrderDetailBean> orderDetails) {
		this.orderDetails = orderDetails;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSendAddress() {
		return sendAddress;
	}
	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public java.util.Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public java.util.Date getPayDate() {
		return payDate;
	}
	public void setPayDate(java.util.Date payDate) {
		this.payDate = payDate;
	}
	public int getTransportPrice() {
		return transportPrice;
	}
	public void setTransportPrice(int transportPrice) {
		this.transportPrice = transportPrice;
	}
	public java.util.Date getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(java.util.Date shippedDate) {
		this.shippedDate = shippedDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOrdersStatus() {
		return ordersStatus;
	}
	public void setOrdersStatus(String ordersStatus) {
		this.ordersStatus = ordersStatus;
	}
	@Override
	public String toString() {
		return "OrdersBean [orderId=" + orderId + ", memberId=" + memberId + ", phone=" + phone + ", email=" + email
				+ ", sendAddress=" + sendAddress + ", receiveName=" + receiveName + ", totalQuantity=" + totalQuantity
				+ ", totalPrice=" + totalPrice + ", orderDate=" + orderDate + ", payMethod=" + payMethod + ", payDate="
				+ payDate + ", transportPrice=" + transportPrice + ", shippedDate=" + shippedDate + ", remark=" + remark
				+ ", ordersStatus=" + ordersStatus + ", orderDetails=" + orderDetails + "]";
	}
	
	
//	@ManyToOne
//	@JoinColumn(
//		name="MEMBERID",
//		referencedColumnName="MEMBERID",
//		insertable=false,
//		updatable=false
//	)
//	private MemberBean member;
//	
	
//	public MemberBean getMember() {
//		return member;
//	}
//	public void setMember(MemberBean member) {
//		this.member = member;
//	}
	
	public OrdersBean(){super();}
	public OrdersBean(String receiveName,int orderId){
		super();
		this.receiveName=receiveName;
		this.orderId=orderId;
	}
	public OrdersBean(int orderId,String memberId,String phone,String email,String sendAddress,
			String receiveName,int totalQuantity,int totalPrice,java.util.Date orderDate,
				String payMethod,java.util.Date payDate,int transportPrice,
					java.util.Date shippedDate,String remark,String ordersStatus){
		super();
		this.orderId=orderId;
		this.memberId=memberId;
		this.phone=phone;
		this.email=email;
		this.sendAddress=sendAddress;
		this.receiveName=receiveName;
		this.totalQuantity=totalQuantity;
		this.totalPrice=totalPrice;
		this.orderDate=orderDate;
		this.payMethod=payMethod;
		this.payDate=payDate;
		this.transportPrice=transportPrice;
		this.shippedDate=shippedDate;
		this.remark=remark;
		this.ordersStatus=ordersStatus;
	}
	

}
