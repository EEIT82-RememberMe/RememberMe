package model.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.json.simple.JSONValue;

import news.model.NoticeBean;
import news.model.NoticeDAO;

public class NoticeDAOHibernate implements NoticeDAO
{
	private Session session;
	public NoticeDAOHibernate(Session session) {
		
		this.session = session;
	}
	public Session getSession() {
		return session;
	}
	
	@Override
	public int getTotalPages() {
		
		List<NoticeBean> list = (List<NoticeBean>) getSession().createQuery("from NoticeBean").list();
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
	public List<NoticeBean> selectByPage(int page) {
		
		List<NoticeBean> list = (List<NoticeBean>) getSession().createQuery("from NoticeBean order by number desc")
				.setFirstResult(3 * (page-1) )
				.setMaxResults(3)
                .list();	
		
		return list;
	}
	@Override
	public String showByPage(int page) 
	{
		String jsonString = null;
		List<NoticeBean> list = (List<NoticeBean>) getSession()
				.createQuery("FROM NoticeBean ORDER BY number DESC")
				.setFirstResult(2 * (page-1) )
				.setMaxResults(2)
                .list();
		int listCount = list.size();
		System.out.println("listcount = ------>"+listCount);
		
		List linkList = new LinkedList(); 
		Map<String,String> map = new HashMap();
		int stopCount = 0;
		
		for(int i= 0; i<listCount; i++)//從最後一筆(最晚加入的資料)在第一頁開始顯示
		{
		    map = new HashMap<String,String>();
			map.put("title", list.get(i).getTitle());
			map.put("date", list.get(i).getDate());
			map.put("photo", list.get(i).getPhoto());
			map.put("noticeContent", list.get(i).getNoticeContent());
			if(i == listCount-1 && i!=1)
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
	public NoticeBean select(int number) 
	{
		return (NoticeBean) getSession().get(NoticeBean.class, number);
	}

	@Override
	public NoticeBean insert(NoticeBean bean) 
	{
		NoticeBean result = (NoticeBean) getSession().get(NoticeBean.class, bean.getNumber());
		if(result==null) 
		{
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public NoticeBean update(int number, String title, String noticeContent,
			String photo,String date,Date updateDate) 
	{
		NoticeBean result = (NoticeBean) getSession().get(NoticeBean.class, number);
		if(result!=null) {
			result.setNumber(number);
			result.setTitle(title);
			result.setNoticeContent(noticeContent); 
			result.setPhoto(photo);
			result.setDate(date);
			result.setUpdateDate(updateDate);
		}
		return result;
	}

	@Override
	public boolean delete(int number) 
	{
		NoticeBean bean = (NoticeBean) getSession().get(NoticeBean.class, number);
		if(bean!=null) {
			getSession().delete(bean);
			return true;
		}
		return false;
	}
	@Override
	public int getTotalDataNum() {
		List<NoticeBean> list = (List<NoticeBean>) getSession().createQuery("from NoticeBean").list();
		int listCount = list.size();
		return listCount;
	}

}
