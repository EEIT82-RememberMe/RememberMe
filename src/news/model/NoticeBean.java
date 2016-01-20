package news.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Notice")
public class NoticeBean 
{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int number;
	private String title;
	private String noticeContent;
	private String photo;
	private String date;
	   private String more;
	private String postedBy;
	private java.util.Date createDate;
	private java.util.Date updateDate;
	
	public NoticeBean() {
		super();
	}
	public NoticeBean(String title,String noticeContent,String photo,String date, Date updateDate) {
		super();
		this.title = title;
		this.noticeContent = noticeContent;
		this.photo = photo;
		this.date = date;
		this.updateDate = updateDate;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getMore() {
		return more;
	}
	public void setMore(String more) {
		this.more = more;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
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
		return "NoticeBean [number=" + number + ", date=" + date + ", title=" + title + ", photo=" + photo
				+ ", noticeContent=" + noticeContent + ", more=" + more + ", postedBy=" + postedBy + ", createDate="
				+ createDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
