package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.sql.ordering.antlr.GeneratedOrderByFragmentParser;

import orders.model.OrderDetailBean;
import orders.model.OrderDetailDAO;
import orders.model.OrdersBean;

public class OrderDetailDAOHibernate implements OrderDetailDAO {
	
	private Session session;
	public OrderDetailDAOHibernate(Session session) {
		super();
		this.session = session;
	}
	public Session getSession() {
		return session;
	}

	@Override
	public OrderDetailBean selectOrder() {
		return null;
	}
	
	@Override
	public List<OrderDetailBean> select(int orderId) {
		return (List<OrderDetailBean>) getSession().createQuery("FROM OrderDetailBean WHERE orderId = " + orderId).list();
	}
	
	@Override
	public OrderDetailBean insert(OrderDetailBean bean) {
		OrderDetailBean result = (OrderDetailBean)getSession().get(OrderDetailBean.class, bean.getOrderDetailId());
		if(result==null){
			getSession().save(bean);
			return bean;
		}
		return null;
	}
	
	@Override
	public void insertMany(int orderId,List<OrderDetailBean> beans) {
		for(OrderDetailBean bean : beans){
			OrderDetailBean result = (OrderDetailBean)getSession().get(OrderDetailBean.class, bean.getOrderId());
			if(result == null){
				this.getSession().save(bean);
			}
		}

		
	}

	
}
