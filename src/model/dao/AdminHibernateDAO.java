
package model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import admin.model.AdminBean;
import admin.model.AdminDAO;
import model.hibernate.HibernateUtil;

public class AdminHibernateDAO implements AdminDAO {
	// ---拿Session-----------------------------------------
	private Session session;

	public AdminHibernateDAO(Session session) {
		super();
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	// ----對資料庫做select(依該id得到整筆資料)---------------------------------------------------
	@Override
	public AdminBean select(String adminId) {
		return (AdminBean) getSession().get(AdminBean.class, adminId);
	}

	// ----對資料庫做select全部的資料---------------------------------------------------
	@Override
	public List<AdminBean> select() {
		try {
			return (List<AdminBean>) getSession().createQuery("from AdminBean").list();
		} catch (Exception e) {
			System.out.println("something is wrong here" + e.getMessage());
		}
		return null;
	}

	// ------對資料庫做insert-----如果資料庫不存在資料則輸入資料,如果存在則不輸入--------------------------------
	@Override
	public AdminBean insert(AdminBean bean) {
		// 如果getAdminId 查詢AdminClass得到整筆完整資料result,則回傳null,不寫任何東西進去資料庫(類似帳號已存在)
		// 如果否,則用save方法將bean存進session
		// System.out.println("xxxx");
		AdminBean result = (AdminBean) getSession().get(AdminBean.class, bean.getAdminId());
		// System.out.println("oooo");
		if (result == null) {
			getSession().save(bean);
			return bean;
		}
		// System.out.println("fffffff");
		return null;

	}
	
	// --------對資料庫資料做update Password------如果資料存在,則覆寫資料）----------
	
	
	
	// ---------update State------------------------
	@Override
	public AdminBean update(String adminId, int state,java.util.Date updateDate) {
//		System.out.println("@@@@@@@@"+updateDate);
		AdminBean result = (AdminBean) getSession().get(AdminBean.class, adminId);
		if (result != null) {
			result.setState(state);
			result.setUpdateDate(updateDate);
//			System.out.println("DAOresult~~~~~"+result);
		}
		return result;
	}

//	------UpdateALL---
@Override
public AdminBean updateAll(AdminBean bean){
	AdminBean result = (AdminBean) getSession().get(AdminBean.class, bean.getAdminId());
	if(result!=null){
		result.setAdminId(bean.getAdminId());
		result.setAdminPassword(bean.getAdminPassword());
		result.setName(bean.getName());
		if(bean.getPhoto()!=null){
			System.out.println("DAO~~~~~~~~"+bean.getPhoto());
		result.setPhoto(bean.getPhoto());
		}
		result.setUpdateDate(bean.getUpdateDate());
		System.out.println("DAOresult===="+result);
	}
	return result;
}
@Override
public AdminBean update(String adminId, String adminPassword, String name, String email, byte[] photo,
		Integer state, Date createDate, Date updateDate) {
	// TODO Auto-generated method stub
	return null;
}
	
//	@Override
//	public AdminBean update(String adminId, String adminPassword, String name, String email, byte[] photo,
//			Integer state, Date createDate, Date updateDate) {
//		AdminBean result = (AdminBean) getSession().get(AdminBean.class, adminId);
//		if (result != null) {
//			result.setAdminPassword(adminPassword);
//			result.setEmail(email);
//			result.setName(name);
//			result.setPhoto(photo);
//			result.setState(state);
//			result.setCreateDate(createDate);
//			result.setUpdateDate(updateDate);
//		}
//
//		return result;
//	}

//	------Update密碼------
	@Override
	public AdminBean updatePass(String adminId, String adminPassword) {
		AdminBean result = (AdminBean) getSession().get(AdminBean.class, adminId);
		if(result!=null){
			result.setAdminPassword(adminPassword);
		}	
		return result;
	}

	// ---對資料庫的一筆資料做delete（依該id刪除整筆資料）----------------------------------------------------
	@Override
	public boolean delete(String adminId) {
		AdminBean bean = (AdminBean) getSession().get(AdminBean.class, adminId);
		if (bean != null) {
			getSession().delete(bean);
			return true;
		}
		return false;
	}



	// public static void main(String[] args) throws Exception{
	//// photo------------------------------
	// File input = new File("/Users/ougoukun/Desktop/LINE 貼圖/10115.png");
	// byte[] photo = new byte[(int)input.length()];
	// FileInputStream fis = new FileInputStream(input);
	// fis.read(photo);
	// fis.close();
	//// Date-------------------------------
	// String dateString = "2015-12-17 13:25:25";
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	// Date date = sdf.parse(dateString);
	// java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	//
	//
	// try {
	// Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	// session.beginTransaction();
	// // ---------select---------------------
	// // AdminBean bean = (AdminBean) session.get(AdminBean.class, "aa1");
	// // --------------------insert---------------
	// AdminBean bean = new AdminBean();
	// bean.setAdminId("test1");
	// bean.setAdminPassword("123");
	// bean.setEmail("jc@hotmail.com");
	// bean.setName("Jesca");
	// bean.setPhoto(photo);
	// bean.setState("1");
	// bean.setCreateDate(sqlDate);
	//// bean.setUpdateDate(updateDate);
	// System.out.println(bean);
	// session.save(bean);
	// session.getTransaction().commit();
	//
	// } finally {
	// HibernateUtil.closeSessionFactory();
	//
	// }
	//
	// }

}
