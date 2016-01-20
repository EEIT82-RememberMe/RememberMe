package admin.model;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

import model.hibernate.HibernateUtil;

@Entity //import persistence
@Table(name="ADMIN")
public class AdminBean {
	@Id
	private String adminId;
	private String adminPassword;
	private String name;
	private String email;
	private byte[] photo;
	private int state;
	private java.util.Date createDate;
	private java.util.Date updateDate;

	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
	@Override
	public String toString() {
		return "AdminBean [adminId=" + adminId + ", adminPassword=" + adminPassword + ", name=" + name + ", email="
				+ email + ", photo=" + Arrays.toString(photo) + ", state=" + state + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + "]";
	}

	// -------------測試程式----------------------------------------------
//	public static void main(String[] args) throws Exception {
//
//		File input = new File("/Users/ougoukun/Desktop/ED製作完成圖/毛怪2拷貝.png");
//		byte[] photo = new byte[(int) input.length()];// length()會得到一個long,但是byte[只能裝int,所以要強制轉型成int]
//		FileInputStream fis = new FileInputStream(input);
//		fis.read(photo);
//		fis.close();
//		try {
//			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//			session.beginTransaction();
//
//			// ------------select----------------------------------------------
//			AdminBean bean = (AdminBean) session.get(AdminBean.class, "aa1");
//
//			// --------delete------------------------------------
//			// session.delete(bean);
//			 System.out.println(bean);
//
//			// -------insert--------------------------------------
//			//
//			 AdminBean adminBean = new AdminBean();
//			
//			 adminBean.setAdminId("JASON");
//			 adminBean.setAdminPassword("456");
//			 adminBean.setEmail("jjj@hotmail.com");
//			 adminBean.setName("Alex");
//			 adminBean.setPhoto(photo);
//			 System.out.println(adminBean);
//			 session.save(adminBean);
//			// ---------udate-----------------------------------------
//			// AdminBean bean2= (AdminBean)session.get(AdminBean.class,"dd12");
//			// bean.setPhoto(photo);
//			// bean2.setName("MERRY");
//
//			// ---------------------------------------------
//			session.getTransaction().commit();
//		} finally {
//			HibernateUtil.closeSessionFactory();
//		}
//	}


	
}
