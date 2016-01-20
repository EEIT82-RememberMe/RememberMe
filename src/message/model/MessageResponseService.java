package message.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;

import model.dao.MessageResponseDAOHibernate;
import model.hibernate.HibernateUtil;

public class MessageResponseService {
	private MessageResponseDAO messageResponseDao;
	public MessageResponseService(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		messageResponseDao = new MessageResponseDAOHibernate(session);
	}
	public MessageResponseBean insert(MessageResponseBean bean){
		MessageResponseBean result=null;
		if(bean!=null){
			result=messageResponseDao.insert(bean);
		}
		return result;
	}

	public List<MessageResponseBean> select(){
		List<MessageResponseBean> result =null;
		
		result = messageResponseDao.select();
//		System.out.println("result="+result);
		return result;
	}

/*
	public MessageResponseBean select(int messageResponseId ){
			MessageResponseBean result = null;
			result = messageResponseDao.select( messageResponseId);
		return result;
	}
*/
	
	public int deleteById(int messageResponseId){
		if(messageResponseDao.select(messageResponseId)!=null){
			messageResponseDao.Delete(messageResponseId);
//			System.out.println("===="+guestId);
			return 1;
		}
		System.out.println(0);
		return 0;
	}
	
	//測試程式
/*
	public static void main(String[] args){
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			MessageResponseService service = new MessageResponseService();
			List<MessageResponseBean> beans = service.select();
			System.out.println(beans);
			
			
//			for (MessageResponseBean ur : beans) {
//				System.out.println("beans:" + ur);
//			}
			
				service.deleteById(11);
			
//			MessageResponseBean bean = new MessageResponseBean();
//			bean.setMemberId("asd1");
//			bean.setMessageId(18);
//			bean.setMessageResponseContent("aadddddddaa");
//			bean.setMessageResponseTime(new Timestamp(new Date().getTime()));
//			service.insert(bean);
			
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}
*/
}
