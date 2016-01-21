package member.model;

import java.sql.SQLException;
import java.util.List;


public interface MemberDAO {
	
	MemberBean select(String memberId);
	
	public MemberBean insertMember(MemberBean bean) throws SQLException;
	 
	public abstract List<MemberBean> select();
	
	

}
