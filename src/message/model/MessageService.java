package message.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.Session;

import model.dao.MessageDAOHibernate;
import model.hibernate.HibernateUtil;


public class MessageService {
	
	private MessageDAO messageDao;
	public MessageService(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		messageDao=new MessageDAOHibernate(session);
	}
	public MessageBean insert(MessageBean bean){
		MessageBean result=null;
		if(bean!=null){
			result=messageDao.insert(bean);
		}
		return result;
	}
	public List<MessageBean> select(){
		List<MessageBean> result =null;
		
			result = messageDao.select();
			
		
//			System.out.println("sevice"+result.get(5).getGuestName());
		
		return result;
	}
//	public GuestBean delete(GuestBean bean){
//		GuestBean result = null;
//		if(bean!=null){
//			System.out.println("======="+bean);
//			result= contactDao.Delete(bean.getGuestID());
//			System.out.println("----------"+result);
//		}
//		return result;
//	}
	public int deleteById(int messageId){
		if(messageDao.select(messageId)!=null){
			messageDao.Delete(messageId);
//			System.out.println("===="+guestId);
			return 1;
		}
		System.out.println(0);
		return 0;
	}
	
	
//	測試程式
	public static void main(String[] args){
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			MessageService service = new MessageService();
			List<MessageBean> beans = service.select();
//			int id=service.deleteById(1);
			for(MessageBean ur:beans){
				System.out.println("beans:"+ur);
			}
			
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
