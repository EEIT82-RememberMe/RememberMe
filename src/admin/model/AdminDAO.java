package admin.model;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface AdminDAO {
	
	public abstract AdminBean select(String adminId);
	public abstract List<AdminBean> select();
	public abstract AdminBean insert(AdminBean bean);
	public abstract boolean delete(String adminId);
	public abstract AdminBean update(String adminId ,String adminPassword,String name,String email,byte[] photo,Integer state,java.util.Date createDate,java.util.Date updateDate);
	public abstract AdminBean update(String adminId,int state,java.util.Date updateDate);
	public abstract AdminBean updatePass(String adminId, String adminPassword);
	public abstract AdminBean updateAll(AdminBean bean);
	
}
