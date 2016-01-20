package news.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import model.dao.NoticeDAOHibernate;
import model.hibernate.HibernateUtil;

public class NoticeService {
	
	private NoticeDAO noticeDao;
	
	public NoticeService() 
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		noticeDao = new NoticeDAOHibernate(session);
	}
	
	public String showByPage(int page)
	{
		String result = null;
		if( page > 0) {
			result = noticeDao.showByPage(page);
		}
		return result;
	}
	public NoticeBean select(int number)
	{
		NoticeBean result = null;
		if( number > 0) {
			result = noticeDao.select(number);
		}
		return result;
	}
	public int getTotalPages()
	{
		return noticeDao.getTotalPages();	
	}
	
	public List<NoticeBean> select(NoticeBean bean,int page) 
	{
		List<NoticeBean> result = null;
		if(bean!=null && bean.getNumber()!=0) {
			NoticeBean temp = noticeDao.select(bean.getNumber());
			if(temp!=null) {
				result = new ArrayList<NoticeBean>();
				result.add(temp);
			}
		} else {
			result = noticeDao.selectByPage(page);
		}
		return result;
	}
	public NoticeBean insert(NoticeBean bean) 
	{
		NoticeBean result = null;
		if(bean!=null) {
			result = noticeDao.insert(bean);
		}
		return result;
	}
	public NoticeBean update(NoticeBean bean) 
	{
		NoticeBean result = null;
		if(bean!=null) {
			result = noticeDao.update(bean.getNumber(),bean.getTitle(), bean.getNoticeContent(),
					bean.getPhoto(), bean.getDate(),bean.getUpdateDate());
		}
		return result;
	}
	public boolean delete(NoticeBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = noticeDao.delete(bean.getNumber());
		}
		return result;
	}
	public int getTotalDataNum()
	{
		return noticeDao.getTotalDataNum();	
	}

}
