package orders.model;

import java.util.List;

public interface OrderDetailDAO {
	
	public OrderDetailBean selectOrder();
	
	public List<OrderDetailBean> select(int orderId);
	
	public OrderDetailBean insert(OrderDetailBean bean);
	
	public void insertMany(int orderId,List<OrderDetailBean> bean);

}
