package message.model;

import java.util.List;

import org.hibernate.sql.Delete;

public interface MessageDAO {

	public abstract MessageBean insert(MessageBean bean);
	public abstract MessageBean select(int messageId);
	public abstract List<MessageBean> select();
//	public abstract MessageResponseBean insert(MessageResponseBean bean);
//	public abstract MessageResponseBean select(int messageResponseId);
	boolean Delete(int messageId);
}
