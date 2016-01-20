package model.dao;

import java.util.List;

import org.hibernate.Session;

import message.model.MessageBean;
import message.model.MessageDAO;

public class MessageDAOHibernate implements MessageDAO {
	@Override
	public boolean Delete(int messageId) {
		MessageBean bean = (MessageBean)getSession().get(MessageBean.class, messageId);
		if(bean!=null){
			session.delete(bean);
			return true;
		}
		
		return false;
	}
	@Override
	public MessageBean select(int messageId) {
		
		return (MessageBean)getSession().get(MessageBean.class, messageId);
	}
	@Override
	public List<MessageBean> select() {
		
		return (List<MessageBean>)getSession().createQuery("from MessageBean order by messageId DESC").list();
	}
	private Session session;
	public MessageDAOHibernate(Session session) {
		super();
		this.session = session;
	}
	public Session getSession() {
		return session;
	}
	@Override
	public MessageBean insert(MessageBean bean) {
		
		MessageBean result = (MessageBean)getSession().get(MessageBean.class, bean.getMessageId());
		if(result==null){
			getSession().save(bean);
			return bean;
		}
		return null;
	}
//	@Override
//	public MessageResponseBean insert(MessageResponseBean bean) {
//		MessageResponseBean result = (MessageResponseBean)getSession().get(MessageResponseBean.class,bean.getMessageResponseId() );
//		if(result==null){
//			getSession().save(bean);
//			return bean;
//		}
//		return null;
//	}
	

}
