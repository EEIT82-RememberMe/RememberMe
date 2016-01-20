package message.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;

import member.model.MemberBean;
import model.hibernate.HibernateUtil;
@Entity
@Table(name="MESSAGEINFORMATIONS")
public class MessageBean implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	<many-to-one name="MEMBER" column="memberId" class="model.MemberBean" cascade="all" outer-join="true" unique="true"></many-to-one>
	private int messageId;
	private Timestamp messageTime;
	private String messageContent;
//	private int guestResponseID;
//	private String guestResponseContent;
//	private Timestamp guestResponseTime;
	private String memberId;
	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public MessageBean(){
		
	}	
	
//	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	public static Timestamp converTime(String date){
//		Timestamp result = null;
//		try{
//			Date result1 = sdf.parse(date);
//			result = new Timestamp(result1.getTime());
//		}catch(Exception e){
//			e.getMessage();
//			result=new Timestamp(0);
//		}
//		return result;
//	}
	
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
	
	
public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public Timestamp getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Timestamp messageTime) {
		this.messageTime = messageTime;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	//	public int getMessageId() {
//		return messageId;
//	}
//	public void setD(int guestID) {
//		this.messageId = guestID;
//	}
//	public Timestamp getGuestTime() {
//		return messageTime;
//	}
//	public void setGuestTime(Timestamp guestTime) {
//		this.messageTime = guestTime;
//	}
//	public String getGuestContent() {
//		return messageContent;
//	}
//	public void setGuestContent(String guestContent) {
//		this.messageContent = guestContent;
//	}
//	public int getGuestResponseID() {
//		return guestResponseID;
//	}
//	public void setGuestResponseID(int guestResponseID) {
//		this.guestResponseID = guestResponseID;
//	}
//	public String getGuestResponseContent() {
//		return guestResponseContent;
//	}
//	public void setGuestResponseContent(String guestResponseContent) {
//		this.guestResponseContent = guestResponseContent;
//	}
//	public Timestamp getGuestResponseTime() {
//		return guestResponseTime;
//	}
//	public void setGuestResponseTime(Timestamp guestResponseTime) {
//		this.guestResponseTime = guestResponseTime;
//	}
	
	
	@ManyToOne
	@JoinColumn(
			name="memberId",
			referencedColumnName="memberId",
			insertable=false,updatable=false
			)
	private MemberBean member;
	@Override
	public String toString() {
		return "MessageBean [messageId=" + messageId + ", messageTime=" + messageTime + ", messageContent="
				+ messageContent + ", memberId=" + memberId + "]";
	}

	@OneToMany(
			mappedBy="messageId",
			cascade={
					javax.persistence.CascadeType.REMOVE
			}
			)
	private Set<MessageResponseBean> messageResponseBean; 


	//測試程式
//	public static void main(String[] args){
//
//		try {
//			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//			session.beginTransaction();
//			
//			MessageBean bean = (MessageBean)session.get(MessageBean.class, 2);
//			System.out.println(bean);
//		
//			MessageBean bean = new MessageBean();
//			bean.setMessageContent("how  you");
//			bean.setMessageTime(new Timestamp(new Date().getTime()));
//			bean.setMemberId("asd1");
//			session.save(bean);
//			
//			session.getTransaction().commit();
//		}catch(Exception e){
//			e.getMessage();
//		} 
//		finally {
//			HibernateUtil.closeSessionFactory();
//		}
//	}
	
	
}
