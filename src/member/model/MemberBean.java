package member.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Member")
public class MemberBean implements java.io.Serializable
{
	@Id
	private String memberId;
	private String memberPassword;
	private String name;
	private String gender;
	private java.util.Date birthday;
	private String phone;
	private String email;
	private String memberAddress;
	private int point;
	private String status;
	private java.util.Date registerDate;
	private java.util.Date updateDate;
	
	public MemberBean() {
		super();
	}
	
	public MemberBean(String memberId, String memberPassword, String email) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberBean [memberId=" + memberId + ", memberPassword=" + memberPassword + ", name=" + name
				+ ", gender=" + gender + ", birthday=" + birthday + ", phone=" + phone + ", email=" + email
				+ ", memberAddress=" + memberAddress + ", point=" + point + ", status=" + status + ", registerDate="
				+ registerDate + ", updateDate=" + updateDate + "]";
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPassword() {
		return memberPassword;
	}
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public java.util.Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(java.util.Date registerDate) {
		this.registerDate = registerDate;
	}
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
