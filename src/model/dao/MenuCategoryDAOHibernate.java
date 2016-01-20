package model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.json.simple.JSONValue;

import menu.model.MenuCategoryDAO;
import menu.model.MenuCategoryBean;


public class MenuCategoryDAOHibernate implements MenuCategoryDAO
{
	private Session session;
	public MenuCategoryDAOHibernate(Session session) {
		
		this.session = session;
	}
	public Session getSession() {
		return session;
	}
	@Override
	public String returnCategories() 
	{
		String jsonString = null;
		List<MenuCategoryBean> list = (List<MenuCategoryBean>) getSession()
						.createQuery("FROM MenuCategoryBean ORDER BY CategoryNum").list();
		
		System.out.println(list);
		int listCount = list.size();
		System.out.println("共 "+listCount +" 筆資料");
		List linkList = new LinkedList();
		Map<String,String> map = new HashMap();
		//List<Object> newList = new ArrayList <Object>();
		
		for(int i= 0; i<listCount; i++)//從第一開始抓
		{
			map = new HashMap<String,String>();
			map.put("value", String.valueOf(list.get(i).getCategoryNum()));
			map.put("text", list.get(i).getCategoryName());
			
			linkList.add(map);
		}
		System.out.println("linklist="+ linkList);
		jsonString = JSONValue.toJSONString(linkList);
		return jsonString;
	}

}
