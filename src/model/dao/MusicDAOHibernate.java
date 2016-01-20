package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONValue;

import model.hibernate.HibernateUtil;
import news.model.MusicBean;
import news.model.MusicDAO;

public class MusicDAOHibernate implements MusicDAO
{
	private Session session;
	public MusicDAOHibernate(Session session) {
		
		this.session = session;
	}
	public Session getSession() {
		return session;
	}
	
	@Override
	public String showByPage(int page) 
	{
		String jsonString = null;
		
		//List<MusicBean> list = (List<MusicBean>) getSession().createQuery("from MusicBean").list();
		List<MusicBean> list = (List<MusicBean>) getSession()
				.createQuery("FROM MusicBean ORDER BY number DESC")
				.setFirstResult(8 * (page-1) )
				.setMaxResults(8)
                .list();
				
		int listCount = list.size();
		System.out.println("listcount = ------>"+listCount);
		
		List linkList = new LinkedList(); 
		Map<String,String> map = new HashMap();
		int stopCount = 0;
/*****************************資料庫取值存成Json字串********************************************************/			
		for(int i= 0; i<listCount; i++)//從最後一筆(最晚加入的資料)在第一頁開始顯示
		{
		    map = new HashMap<String,String>();
			map.put("title", list.get(i).getTitle());
			map.put("description", list.get(i).getDescription());
			map.put("photo", list.get(i).getPhoto());
			map.put("performer", list.get(i).getPerformer());
			map.put("musicContent", list.get(i).getMusicContent());
			map.put("blogLink", list.get(i).getBlogLink());
			if(i == listCount-1 && i!=7)
			{
				map.put("lastData", "true");
			}
			else
			{
				map.put("lastData", "false");
			}	
			linkList.add(map);
				System.out.println("i="+i + "linklist="+ linkList);
		}
		jsonString = JSONValue.toJSONString(linkList);
		return jsonString;	
	}
	
	@Override
	public MusicBean select(int number) {
		return (MusicBean) getSession().get(MusicBean.class, number);
	}
	
	@Override
	public int getTotalPages() {
		
		List<MusicBean> list = (List<MusicBean>) getSession().createQuery("from MusicBean").list();
		int listCount = list.size();
		int pages = 0;
		if(listCount%3 ==  0)
		{
			pages = (listCount / 3);
		}
		else if(listCount%3 != 0)
		{
			pages = (listCount / 3) + 1;
		}
		
		return pages;
	}
	@Override
	public int getTotalDataNum() {
		List<MusicBean> list = (List<MusicBean>) getSession().createQuery("from MusicBean").list();
		int listCount = list.size();
		return listCount;
	}
	
	@Override
	public List<MusicBean> selectByPage(int page) {
		
		List<MusicBean> list = (List<MusicBean>) getSession().createQuery("from MusicBean order by number desc")
				.setFirstResult(3 * (page-1) )
				.setMaxResults(3)
                .list();	
		
		return list;
	}

	@Override
	public MusicBean insert(MusicBean bean)
	{
		MusicBean result = (MusicBean) getSession().get(MusicBean.class, bean.getNumber());
		if(result==null) 
		{
			getSession().save(bean);
			return bean;
		}
		return null;
	}
	@Override
	public MusicBean update(int number,String title, String description, String photo, 
			String performer, String musicContent,String blogLink,java.util.Date updateDate) 
	{
		MusicBean result = (MusicBean) getSession().get(MusicBean.class, number);
		if(result!=null) {
			result.setNumber(number);
			result.setTitle(title);
			result.setDescription(description);
			if(photo!=null)
			{
				result.setPhoto(photo);
			}
			result.setPerformer(performer);
			result.setMusicContent(musicContent);
			result.setBlogLink(blogLink);
			result.setUpdateDate(updateDate);
		}
		return result;
	}
	@Override
	public boolean delete(int number)
	{
		MusicBean bean = (MusicBean) getSession().get(MusicBean.class, number);
		if(bean!=null) {
			getSession().delete(bean);
			return true;
		}
		return false;
	}
//	@Override
//	public Date getRecentDate() 
//	{
//		java.util.Date date = (java.util.Date)getSession().createQuery("select max(updateDate) from MusicBean");
//		System.out.println("----"+date);
//		return date;
//	}	
}
