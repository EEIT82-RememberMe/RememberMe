package model.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.hibernate.Session;

import model.hibernate.HibernateUtil;
import orders.model.OrderDetailBean;
import orders.model.OrdersBean;
import orders.model.OrdersDAO;

public class OrdersDAOHibernate implements OrdersDAO {
	
	private Session session;
	public OrdersDAOHibernate(Session session) {
		super();
		this.session = session;
	}
	public Session getSession() {
		return session;
	}

	@Override
	public OrdersBean select(int orderId) {
		return (OrdersBean) getSession().get(OrdersBean.class, orderId);
	}
	
	@Override
	public List<OrdersBean> selectMemberOrders(String memberId) {
		return (List<OrdersBean>) getSession().createQuery("FROM OrdersBean WHERE memberId = " + memberId + "ORDER BY orderDate DESC").list();
	}
	
	@Override
	public List<OrdersBean> selectList() {
		return (List<OrdersBean>) getSession().createQuery("FROM OrdersBean WHERE ordersStatus = '處理中'").list();
	}

	@Override
	public OrdersBean insert(OrdersBean bean) {
		OrdersBean result = (OrdersBean)getSession().get(OrdersBean.class, bean.getOrderId());
		if(result==null){
//			int id=(int) (Math.random()*1000000);
//			
//			OrdersBean order=new OrdersBean();
//			order.setOrderId(id);
//			
//			OrderDetailBean orderDetail=new OrderDetailBean(id);
//			Set<OrderDetailBean> od=new HashSet<OrderDetailBean>();
//			
//			od.add(orderDetail);
//			order.setOrderDetails(od);
//			session.save(order);
			
			getSession().save(bean);
			return bean;
		}
		return null;
	}
	
//	public static void main(String args[]){
//		try {
//			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//			session.beginTransaction();
//
//			OrdersDAO dao = new OrdersDAOHibernate(session);
//			
//			List<OrdersBean> bean = dao.selectList();
//			System.out.println(bean);
////			List<OrdersBean> beans = dao.selectMemberOrders("123");
////			System.out.println(beans);
//			String m = "123";
//			int id=(int) (Math.random()*1000000);
//			
//			OrdersBean order=new OrdersBean();
//			order.setOrderId(id);
//			order.setMemberId(m);
//			order.setReceiveName("小胖");
//			
////			OrderDetailBean orderDetail=new OrderDetailBean(id);
//			OrderDetailBean orderDeta=new OrderDetailBean(id,m);
////			orderDetail.setPhone("0911222333");
//			orderDeta.setPhone("0911222333");
//			
//			Set<OrderDetailBean> od=new HashSet<OrderDetailBean>();
//			
////			od.add(orderDetail);
//			od.add(orderDeta);
//			order.setOrderDetails(od);
//			session.save(order);
//			
//			session.getTransaction().commit();
//		} finally {
//			HibernateUtil.closeSessionFactory();
//		}
//	}
	
	

}
