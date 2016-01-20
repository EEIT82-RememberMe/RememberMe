package admin.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import model.dao.AdminHibernateDAO;
import model.hibernate.HibernateUtil;

public class AdminService {
	private AdminDAO adminDAO;

	public AdminService() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		adminDAO = new AdminHibernateDAO(session);
		// System.out.println(session);
	}

	// ----------登入方法SELECT單筆資料-----------------------------------------------------
	public AdminBean login(String adminId, String adminPassword) {// 使用者輸入
		AdminBean bean = adminDAO.select(adminId);// 用輸入的帳號id抓出完整資料塞到bean寫到bean裡
		if (bean != null) {// 如果資料庫有此帳號則驗證密碼
			if (adminPassword != null && adminPassword.length() != 0) {// 如果有輸入密碼
				String pass = bean.getAdminPassword();// 資料庫的密碼
				String temp = adminPassword;
				if (pass.equals(temp)) {
					return bean;
				}
				System.out.println("password uncorrect");
			}
			System.out.println("password can't not be null or space");
		}
		System.out.println("no such Id");
		return null;
	}

	// ---------select全部資料-----------------------------------------------
	public List<AdminBean> select(AdminBean bean) {
		List<AdminBean> result = null;
		if (bean != null && bean.getAdminId() != null) {
			// System.out.println("adminDAO="+adminDAO);
			AdminBean temp = adminDAO.select(bean.getAdminId());
			// System.out.println("temp" + temp);
			if (temp != null) {
				result = new ArrayList<AdminBean>();
				result.add(temp);
			}
		} else {
			// System.out.println("hahahah");
			result = adminDAO.select();
			// System.out.println("result=" + result);
		}
		// System.out.println("kkk");
		return result;
	}

	// -----delete方法(依該id刪除整筆資料)-----------------------------------------------
	public boolean delete(AdminBean bean) {
		boolean result = false;
		if (bean != null) {
			adminDAO.delete(bean.getAdminId());
		}
		return result;
	}

	// ---update個人資料-------------------------------------------------
	public AdminBean updateAll(AdminBean bean) {
		AdminBean result = null;
		if (bean != null) {
//			System.out.println("bean~~~~"+bean);
			result = adminDAO.updateAll(bean);
//			System.out.println("result~~~~"+result);
		}
		return result;
	}

	// --------Update權限------------------
	public AdminBean update(AdminBean bean) {
//		System.out.println("Service bean ********"+bean);
		AdminBean result = null;
		if (bean != null) {
			// System.out.println("adminDao=~~~~~~~~~~~~~"+adminDAO);
			result = adminDAO.update(bean.getAdminId(), bean.getState(),bean.getUpdateDate());
//			System.out.println("~~~~~~"+bean.getUpdateDate());
//			System.out.println("ServiceResult========="+result);
		}
		return result;
	}

	// ----------Update密碼------------------------------
	public AdminBean changePassword(String adminId, String oldPassword, String newPassword) {
		// System.out.println("!!!!!!!@@@@");
		AdminBean bean = this.login(adminId, oldPassword);
		// System.out.println("bean:======="+bean);
		if (bean != null) {
			// System.out.println("chang%%%%%%%%");
			if (newPassword != null && newPassword.length() != 0) {
				bean = adminDAO.updatePass(adminId, newPassword);
				return bean;
			}
		}
		return null;
	}
//	 public static void main(String []args){
//	 Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//	 try {
//	 session.beginTransaction();
//	 AdminService service = new AdminService();
//	 service.changePassword("b", "123", "1");
//	 session.getTransaction().commit();
//	 } finally {
//	 HibernateUtil.closeSessionFactory();
//	 }
//	 }
//	 public boolean changeName(String adminId, String adminPassword, String
//	 newName) {
//	 AdminBean bean = this.login(adminId, adminPassword);
//	 if (bean != null) {
//	 if (newName != null && newName.length() != 0) {
//	 return adminDAO.update(adminId, adminPassword, newName, bean.getEmail(),
//	 bean.getPhoto(),
//	 bean.getState(), bean.getCreateDate(), bean.getUpdateDate());
//	 }
//	 }
//	 return false;
//	 }
//	
//	 public boolean changePhoto(String adminId, String adminPassword, byte[]
//	 newPhoto) {
//	 AdminBean bean = this.login(adminId, adminPassword);
//	 if (bean != null) {
//	 if (newPhoto != null && newPhoto.length != 0) {
//	 return adminDAO.update(adminId, adminPassword, bean.getName(),
//	 bean.getEmail(), newPhoto,
//	 bean.getState(), bean.getCreateDate(), bean.getUpdateDate());
//	 }
//	 }
//	 return false;
//	
//	 }
//
//	public static void main(String[] args) throws IOException, ParseException {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		try {
//			session.beginTransaction();
//			AdminBean bean = new AdminBean();
//			AdminService service = new AdminService();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
//			Date date = new Date();
//			String strDate = sdf.format(date);
//			Date now = sdf.parse(strDate);
//			java.sql.Date sqlDate = new java.sql.Date(now.getTime());
//			File file = new File("/Users/ougoukun/Desktop/LINE 貼圖/10126.png");
//			byte[] bt = new byte[(int) file.length()];
//			FileInputStream fis = new FileInputStream(file);
//			fis.read(bt);
//			fis.close();
//			bean.setAdminId("k");
//			bean.setAdminPassword("789");
//			bean.setName("TOM");
//			bean.setEmail("test@tt");
//			bean.setUpdateDate(sqlDate);
//			bean.setPhoto(bt);
//		AdminBean result	= service.updateAll(bean);
//			System.out.println(bean);
//			System.out.println(result);
//			session.getTransaction().commit();
//		} finally {
//			HibernateUtil.closeSessionFactory();
//		}
//
//	}
	// ---測試程式----------------------
	// public static void main(String[] args) throws Exception{
	// File input = new File("/Users/ougoukun/Desktop/ED製作完成圖/螢幕快照 2012-10-09
	// 上午6.18.37拷貝.png");
	// byte[] photo = new byte[(int)input.length()];
	// FileInputStream fis = new FileInputStream(input);
	// fis.read(photo);
	// fis.close();
	// try {
	// Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	// session.beginTransaction();
	//
	// AdminService service = new AdminService();
	// AdminBean select = service.login("aa1", "456");
	// boolean updatePass = service.changePassword("aa1", "1234", "12345");
	// boolean updateName = service.changeName("aa1", "12345", "TOM");
	// boolean updatePhoto = service.changePhoto("aa1", "12345", photo);
	// System.out.println(select);
	// System.out.println("更新PASSWORD" + updatePass);
	// System.out.println("更新Name"+updateName);
	// System.out.println("更新Photo"+updatePhoto);
	// session.getTransaction().commit();
	// } finally {
	// HibernateUtil.closeSessionFactory();
	// }
	//
	// }
}
