package menu.model;

import java.util.Date;
import java.util.List;

public interface MenuFoodDAO {
	
	public abstract String select(int categoryNum);
	
	public abstract List<MenuFoodBean> select();
	
	public abstract MenuFoodBean selectSingleItem(int foodId);
	
	public abstract MenuFoodBean insert(MenuFoodBean bean);
	
	public abstract MenuFoodBean update(int foodId,String foodNameTw,String foodNameUs,String textDecoration
										,String info,String temperature,String price,java.util.Date updateDate);
    
	public abstract boolean delete(int foodId); 
}
