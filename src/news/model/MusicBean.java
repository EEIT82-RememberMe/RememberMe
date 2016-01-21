package news.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import model.hibernate.HibernateUtil;
@Entity
@Table(name="Music")
public class MusicBean implements java.io.Serializable
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int number;
	private String title;
	private String description;
	private String photo;
	private String performer;
	private String musicContent;
	private String blogLink;
	private java.util.Date createDate;
	private java.util.Date updateDate;
	
	
	public MusicBean() {
		super();
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getPerformer() {
		return performer;
	}
	public void setPerformer(String performer) {
		this.performer = performer;
	}
	public String getMusicContent() {
		return musicContent;
	}
	public void setMusicContent(String musicContent) {
		this.musicContent = musicContent;
	}
	public String getBlogLink() {
		return blogLink;
	}
	public void setBlogLink(String blogLink) {
		this.blogLink = blogLink;
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
		//return String.format("{title:%s,", title) + String.format("description:%s", description);
		return "[title:" + title + ", description:" + description + ", photo:" + photo
				+ ", performer:" + performer + ", musicContent:" + musicContent + "]";
	}
	
	public static void main(String[] args)
	{
		try 
		{
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();

			MusicBean bean = (MusicBean) session.load(MusicBean.class, 1);
			System.out.println(bean);
			
			session.getTransaction().commit();
		} 
		finally 
		{
			HibernateUtil.closeSessionFactory();
		}
	}
}
