package news.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import model.dao.MusicDAOHibernate;
import model.hibernate.HibernateUtil;

public class MusicService 
{
	private MusicDAO musicDao;
	public MusicService() 
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		musicDao = new MusicDAOHibernate(session);
	}
	public String showByPage(int page)
	{
		String result = null;
		if( page > 0) {
			result = musicDao.showByPage(page);
		}
		return result;
	}
	public MusicBean select(int number)
	{
		MusicBean result = null;
		if( number > 0) {
			result = musicDao.select(number);
		}
		return result;
	}
	public int getTotalPages()
	{
		return musicDao.getTotalPages();	
	}
	public int getTotalDataNum()
	{
		return musicDao.getTotalDataNum();	
	}
//	public java.util.Date getRecentDate()
//	{
//		return musicDao.getRecentDate();	
//	}
	
	public List<MusicBean> select(MusicBean bean,int page) 
	{
		List<MusicBean> result = null;
		if(bean!=null && bean.getNumber()!=0) {
			MusicBean temp = musicDao.select(bean.getNumber());
			if(temp!=null) {
				result = new ArrayList<MusicBean>();
				result.add(temp);
			}
		} else {
			result = musicDao.selectByPage(page); 
		}
		return result;
	}	
	public MusicBean insert(MusicBean bean) 
	{
		MusicBean result = null;
		if(bean!=null) {
			result = musicDao.insert(bean);
		}
		return result;
	}
	public MusicBean update(MusicBean bean) 
	{
		MusicBean result = null;
		if(bean!=null) {
			result = musicDao.update(bean.getNumber(),bean.getTitle(), bean.getDescription(),
					bean.getPhoto(), bean.getPerformer(), bean.getMusicContent(),
					bean.getBlogLink(),bean.getUpdateDate());
		}
		return result;
	}
	public boolean delete(MusicBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = musicDao.delete(bean.getNumber());
		}
		return result;
	}
//	public static void main(String[] args) 
//	{
//		try {
//			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//			session.beginTransaction();
///**********************************測試程式*******************************************/
//			MusicService service = new MusicService();
//			List<MusicBean> beans = service.select(null);
//			System.out.println("beans="+beans);		
//			System.out.println(service.select(2));
//			System.out.println("jsahahdhasfghjafghjgafjgflahg");
///***************************************************************************************/			
//			session.getTransaction().commit();
//			} 
//			finally
//			{
//				HibernateUtil.closeSessionFactory();
//			}
//	}

}
