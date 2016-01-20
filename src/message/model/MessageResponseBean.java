package message.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;

import model.hibernate.HibernateUtil;
@Entity
@Table(name="MESSAGERESPONSES")
public class MessageResponseBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int messageResponseId;
	private Timestamp messageResponseTime;
	private String messageResponseContent;
	private String memberId;
	private int messageId;
	
	public MessageResponseBean(){
		
	}
	
	public int getMessageResponseId() {
		return messageResponseId;
	}
	public void setMessageResponseId(int messageResponseId) {
		this.messageResponseId = messageResponseId;
	}
	public Timestamp getMessageResponseTime() {
		return messageResponseTime;
	}
	public void setMessageResponseTime(Timestamp messageResponseTime) {
		this.messageResponseTime = messageResponseTime;
	}
	public String getMessageResponseContent() {
		return messageResponseContent;
	}
	public void setMessageResponseContent(String messageResponseContent) {
		this.messageResponseContent = messageResponseContent;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	
	public static int converId(String messageId){
		int result = 0;
		try{
			result = Integer.parseInt(messageId);
		}catch(Exception e){
			e.getMessage();
			return -1000;
		}
		return result;
	}
	@Override
	public String toString() {
		return "MessageResponseBean [messageResponseId=" + messageResponseId + ", messageResponseTime="
				+ messageResponseTime + ", messageResponseContent=" + messageResponseContent + ", memberId=" + memberId
				+ ", messageId=" + messageId + "]";
	}

	@ManyToOne
	@JoinColumn(
			name="messageId",
			referencedColumnName="messageId",
			insertable=false,updatable=false
			)
	private MessageBean messageBean;

	//測試程式
	public static void main(String[] args){
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
//			MessageResponseBean bean = new MessageResponseBean();
//			bean.setMemberId("asd1");
//			bean.setMessageId(18);
//			bean.setMessageResponseContent("aaaaaaa");
//			bean.setMessageResponseTime(new Timestamp(new Date().getTime()));
//			session.save(bean);
			
			MessageResponseBean bean = (MessageResponseBean)session.get(MessageResponseBean.class, 11);
			System.out.println(bean);
			
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
		
		
	}
}
