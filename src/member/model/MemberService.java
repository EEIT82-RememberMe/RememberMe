package member.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import model.dao.MemberDAOHibernate;
import model.hibernate.HibernateUtil;

public class MemberService 
{
	private MemberDAO memberDao;
	public MemberService() 
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//session.beginTransaction().begin();
		memberDao = new MemberDAOHibernate(session);
		
	}
	public MemberBean selectMember(String memberId){
		return memberDao.select(memberId);
	}
	public MemberBean insertMember(MemberBean bean) throws SQLException {
		MemberBean result = null;
		if(bean!=null) {
			result = memberDao.insertMember(bean);
		}
		return result;
	}
	public MemberBean login(String memberId, String memberPassword) 
	{	
		MemberBean bean = memberDao.select(memberId);
		System.out.println(bean);
		System.out.println("im out");
		if(bean!=null) 
		{
			if(memberPassword!=null && memberPassword.length()!=0) 
			{
				
				String pass = bean.getMemberPassword();//資料庫抓出的密碼
				String temp = memberPassword;          //使用者輸入的密碼
				if(pass.equals(temp)) 
				{
					return bean;
				}
			}
		}
		return null;
	}
	public MemberBean select(String memberId)
	{
		MemberBean result = null;
		if( memberId != null) {
			result = memberDao.select(memberId);
		}
		return result;
	}
	
	public List<MemberBean> select(MemberBean bean) 
	{
		List<MemberBean> result = null;
		if(bean!=null && bean.getMemberId()!=null) {
			MemberBean temp = memberDao.select(bean.getMemberId());
			if(temp!=null) {
				result = new ArrayList<MemberBean>();
				result.add(temp);
			}
		} else {
			result = memberDao.select(); 
		}
		return result;
	}
}
