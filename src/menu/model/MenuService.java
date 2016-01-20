package menu.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import model.dao.MenuCategoryDAOHibernate;
import model.dao.MenuFoodDAOHibernate;
import model.hibernate.HibernateUtil;

public class MenuService {
	
	private MenuCategoryDAO menuDao;
	private MenuFoodDAO foodDao;
	public MenuService() 
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		menuDao = new MenuCategoryDAOHibernate(session);
		foodDao = new MenuFoodDAOHibernate(session);
	}
	
	public String returnCategories()
	{
		return menuDao.returnCategories();
	}
	
	public String select(int categoryNum)
	{
		String result = null;
		if( categoryNum > 0) {
			result = foodDao.select(categoryNum);
		}
		return result;
	}
	public MenuFoodBean selectSingleItem(int foodId)
	{
		MenuFoodBean result = null;
		if( foodId > 0) {
			result = foodDao.selectSingleItem(foodId);
		}
		return result;
	}
	public MenuFoodBean insert(MenuFoodBean bean) 
	{
		MenuFoodBean result = null;
		if(bean!=null) {
			result = foodDao.insert(bean);
		}
		return result;
	}
	public MenuFoodBean update(MenuFoodBean bean) 
	{
		MenuFoodBean result = null;
		if(bean!=null) {
			result = foodDao.update(bean.getFoodId(),bean.getFoodNameTw(), bean.getFoodNameUs(),
					bean.getTextDecoration(), bean.getInfo(), bean.getTemperature(),
					bean.getPrice(),bean.getUpdateDate());
		}
		return result;
	}
	public boolean delete(MenuFoodBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = foodDao.delete(bean.getFoodId());
		}
		return result;
	}
//	public List<MenuFoodBean> select(MenuFoodBean bean) 
//	{
//		List<MenuFoodBean> result = null;
//		if(bean!=null && bean.getFoodId()!=0) {
//			MenuFoodBean temp = foodDao.select(bean.getFoodId());
//			if(temp!=null) {
//				result = new ArrayList<MenuFoodBean>();
//				result.add(temp);
//			}
//		} else {
//			result = foodDao.select(); 
//		}
//		return result;
//	}

}
