package model.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.json.simple.JSONValue;

import menu.model.MenuFoodBean;
import menu.model.MenuFoodDAO;

public class MenuFoodDAOHibernate implements MenuFoodDAO
{
	private Session session;
	public MenuFoodDAOHibernate(Session session) 
	{
		
		this.session = session;
	}
	public Session getSession() {
		return session;
	}
	
	@Override
	public String select(int categoryNum) 
	{
		String jsonString = null;
		//System.out.println("in");
		List<MenuFoodBean> list = (List<MenuFoodBean>) getSession()
				.createQuery("FROM MenuFoodBean WHERE categoryNum =" + categoryNum).list();
		int listCount = list.size();
		List linkList = new LinkedList();
		Map<String,String> map = new HashMap();
		
		for(int i= 0; i<listCount; i++)
		{
			map = new HashMap<String,String>();
			map.put("foodId", String.valueOf(list.get(i).getFoodId()));
			map.put("categoryName", list.get(i).getCategoryName());
			map.put("foodNameTw", list.get(i).getFoodNameTw());
			map.put("foodNameUs", list.get(i).getFoodNameUs());
			map.put("textDecoration", list.get(i).getTextDecoration());
			map.put("info", list.get(i).getInfo());
			map.put("temperature", list.get(i).getTemperature());
			map.put("price", list.get(i).getPrice());
			map.put("updateDate", String.valueOf(list.get(i).getUpdateDate()).substring(0, 16));
			
			linkList.add(map);
		}
		//System.out.println("linklist="+ linkList);
		jsonString = JSONValue.toJSONString(linkList);
		return jsonString;
	}

	@Override
	public List<MenuFoodBean> select() 
	{
		return null;
	}
	@Override
	public MenuFoodBean selectSingleItem(int foodId) 
	{
		return (MenuFoodBean) getSession().get(MenuFoodBean.class, foodId);
	}
	@Override
	public MenuFoodBean insert(MenuFoodBean bean) 
	{
		MenuFoodBean result = (MenuFoodBean) getSession().get(MenuFoodBean.class, bean.getFoodId());
		if(result==null) 
		{
			getSession().save(bean);
			return bean;
		}
		return null;
	}
	@Override
	public MenuFoodBean update(int foodId,String foodNameTw, String foodNameUs, 
			String textDecoration, String info, String temperature, String price,
			java.util.Date updateDate) 
	{
		MenuFoodBean result = (MenuFoodBean) getSession().get(MenuFoodBean.class, foodId);
		if(result!=null) {
			result.setFoodId(foodId);
			result.setFoodNameTw(foodNameTw);
			result.setFoodNameUs(foodNameUs);
			result.setTextDecoration(textDecoration);
			result.setInfo(info);
			result.setTemperature(temperature);
			result.setPrice(price);
			result.setUpdateDate(updateDate);
		}
		return result;
	}
	@Override
	public boolean delete(int foodId) 
	{
		MenuFoodBean bean = (MenuFoodBean) getSession().get(MenuFoodBean.class, foodId);
		if(bean!=null) {
			getSession().delete(bean);
			return true;
		}
		return false;
	}
	

}
