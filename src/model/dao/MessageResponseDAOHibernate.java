package model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import message.model.MessageBean;
import message.model.MessageResponseBean;
import message.model.MessageResponseDAO;


public class MessageResponseDAOHibernate implements MessageResponseDAO {
	
	private Session session;
	public MessageResponseDAOHibernate(Session session) {
		super();
		this.session = session;
	}
	public Session getSession() {
		return session;
	}
	
	@Override
	public MessageResponseBean insert(MessageResponseBean bean) {
		MessageResponseBean result = (MessageResponseBean)getSession().get(MessageResponseBean.class,bean.getMessageResponseId() );
		if(result==null){
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public MessageResponseBean select(int messageResponseId) {
		return (MessageResponseBean)getSession().get(MessageResponseBean.class, messageResponseId);
	}

	@Override
	public List<MessageResponseBean> select() {
		String sql ="from MessageResponseBean order by messageResponseId DESC";
		Query query = getSession().createQuery(sql);
//		query.setParameter(19, "messageId");
		List<MessageResponseBean> result = query.list();
//		return (List<MessageResponseBean>)getSession().createQuery("from MessageResponseBean where messageId= :messageId").list();
	return result;
	}
	
	@Override
	public boolean Delete(int messageResponseId) {
		MessageResponseBean bean = (MessageResponseBean)getSession().get(MessageResponseBean.class, messageResponseId);
		if(bean!=null){
			session.delete(bean);
			return true;
		}
		
		return false;
	}
	
}
