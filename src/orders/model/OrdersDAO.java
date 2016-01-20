package orders.model;

import java.util.List;

public interface OrdersDAO {
	
	public OrdersBean select(int orderId);
	
	public List<OrdersBean> selectMemberOrders(String memberId);
	
	public List<OrdersBean> selectList();
	
	public OrdersBean insert(OrdersBean bean);

}
