package model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import member.model.MemberBean;
import member.model.MemberDAO;

public class MemberDAOHibernate implements MemberDAO
{
	private Session session;
	public MemberDAOHibernate(Session session) {
		
		this.session = session;
	}
	public Session getSession() {
		return session;
	}
	
	
	@Override
	public MemberBean select(String memberId) 
	{
		System.out.println("i am in");
		
		return(MemberBean)getSession().get(MemberBean.class,memberId );
	}
	@Override
	public MemberBean insertMember(MemberBean bean) 
	{
		MemberBean result = (MemberBean) getSession().get(MemberBean.class, bean.getMemberId());
		if(result==null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}
	@Override
	public List<MemberBean> select() 
	{
		return (List<MemberBean>) getSession().createQuery("from MemberBean").list();
	}

}
