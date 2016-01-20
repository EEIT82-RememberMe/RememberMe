package orders.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import model.dao.OrderDetailDAOHibernate;
import model.dao.OrdersDAOHibernate;
import model.hibernate.HibernateUtil;

public class OrderService {
	
	private OrdersDAO orderDao ;
	private OrderDetailDAO orderDetailDao ;
	
	public OrderService() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		orderDao = new OrdersDAOHibernate(session);
		orderDetailDao = new OrderDetailDAOHibernate(session);
	}
	
	public OrdersBean selectSimple(int orderId){
		return orderDao.select(orderId);
	}
	
	public List<OrdersBean> select(OrdersBean bean) {
		List<OrdersBean> result = null;
		if(bean!=null && bean.getOrderId()!=0) {
			OrdersBean temp = (OrdersBean) orderDao.select(bean.getOrderId());
			if(temp!=null) {
				result = new ArrayList<OrdersBean>();
				result.add(temp);
			}
		} else {
			result = orderDao.selectList(); 
		}
		return result;
	}
	
	public List<OrderDetailBean> select(int orderId) {
		return orderDetailDao.select(orderId);
	}
	
	public List<OrdersBean> selectMemberOrders(String memberId) {
		return orderDao.selectMemberOrders(memberId);
	}
//	public List<OrdersBean> selectMemberOrders(OrdersBean bean) {
//		List<OrdersBean> result = null;
//		if(bean!=null && bean.getOrderId()!=0) {
//			OrdersBean temp = (OrdersBean) orderDao.selectMemberOrders(bean.getMemberId());
//			if(temp!=null) {
//				result = new ArrayList<OrdersBean>();
//				result.add(temp);
//			}
//		} else {
//			result = orderDao.selectMemberOrders(bean.getMemberId()); 
//		}
//		return result;
//	}
	
	
	public OrdersBean insert(OrdersBean bean) {
		OrdersBean result = null;
		if(bean!=null) {
			result = orderDao.insert(bean);
		}
		return result;
	}
	
	public void insert(int orderId,List<OrderDetailBean> beans) {
		orderDetailDao.insertMany(orderId, beans);
	}
	
	public OrderDetailBean insert(OrderDetailBean bean) {
		OrderDetailBean result = null;
		if(bean!=null) {
			result = orderDetailDao.insert(bean);
		}
		return result;
	}
	
//	public static void main(String[] args) {
//		try {
//			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//			session.beginTransaction();
//			
//			OrdersDAO dao = new OrdersDAOHibernate(session);
//
//			OrderService service = new OrderService();
//			List<OrdersBean> beans = service.select(null);
//			System.out.println("beans="+beans);
//			List<OrdersBean> bean = service.selectMemberOrders(null);
//			System.out.println("beans="+bean);
//			
//			String m = "123";
//			int id=(int) (Math.random()*1000000);
//			OrdersBean insert = new OrdersBean();
//			insert.setOrderId(id);
//			insert.setMemberId(m);
//			insert.setReceiveName("小胖");
//			insert = service.insert(insert);
////			System.out.println(insert);
//			OrderDetailBean orderDetail=new OrderDetailBean(id,m);
//			orderDetail.setPhone("0911222333");
//			
//			Set<OrderDetailBean> od=new HashSet<OrderDetailBean>();
//			
//			od.add(orderDetail);
//			insert.setOrderDetails(od);
//			session.save(insert);
//			
//			session.getTransaction().commit();
//		} finally {
//			HibernateUtil.closeSessionFactory();
//		}
//		
//	}



}
