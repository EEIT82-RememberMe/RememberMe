package news.model;

import java.util.List;

public interface MusicDAO 
{	
	public abstract int getTotalPages();
	public abstract String showByPage(int page);
	public abstract int getTotalDataNum();
	public abstract MusicBean select(int number);
	public abstract List<MusicBean> selectByPage(int page);
	//public abstract java.util.Date getRecentDate(); 
	
	//新增
	public abstract MusicBean insert(MusicBean bean);
	//修改
	public abstract MusicBean update(int number,String title,String description,String photo
									  ,String performer,String musicContent,String blogLink
									  ,java.util.Date updateDate);
	//刪除
	public abstract boolean delete(int number);
}
