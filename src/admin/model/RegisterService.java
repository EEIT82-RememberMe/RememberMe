package admin.model;

import java.sql.SQLException;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;

import model.dao.AdminHibernateDAO;
import model.hibernate.HibernateUtil;

public class RegisterService {
	private AdminDAO adminDAO;

	public RegisterService() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		 adminDAO = new AdminHibernateDAO(session);
//		System.out.println(session);
	}
	
//	public boolean idExist(String adminId){
//		AdminBean bean = adminDAO.select(adminId);
//		if(bean!=null){
//			String id = bean.getAdminId();
//			String temp = adminId;
//			if(id.equals(temp)){
//				System.out.println("hihihihi");
//				return true;
//			}
//		}
//		System.out.println("hahahaha");
//		return false;
//	}
	public AdminBean saveAdmin(AdminBean bean) {
//		System.out.println(bean.getAdminId());
		AdminBean result = null;
//		System.out.println("dao"+adminDAO);
		if(bean!=null){
//			System.out.println("-------"+bean);
			result = adminDAO.insert(bean);
//			System.out.println("result:"+result);
			
		}
		return result;
		
	}
	
	
}
