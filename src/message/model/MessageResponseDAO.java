package message.model;

import java.util.List;

public interface MessageResponseDAO {
	public abstract MessageResponseBean insert(MessageResponseBean bean);
	public abstract MessageResponseBean select(int messageResponseId);
	public abstract List<MessageResponseBean> select();
	boolean Delete(int messageResponseId);
}
