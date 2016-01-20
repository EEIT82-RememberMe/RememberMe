package news.model;

import java.util.List;

public interface NoticeDAO {
	
	public abstract int getTotalPages();
	//依頁數顯示資料
	public abstract String showByPage(int page);
	//查詢
	public abstract NoticeBean select(int number);//查詢單筆
	public abstract List<NoticeBean> selectByPage(int page);
	// 新增
	public abstract NoticeBean insert(NoticeBean bean);
	// 修改
	public abstract NoticeBean update(int number, String title, String noticeContent,
			String photo,String date, java.util.Date updateDate);
	// 刪除
	public abstract boolean delete(int number);
	//取得資料總筆數
	public abstract int getTotalDataNum();
}
