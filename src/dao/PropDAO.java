package dao;
import java.util.Collection;

public interface PropDAO<T> {
	 T select(T dt)  throws Exception;
	void update(T dt) throws Exception;
	void insert(T dt) throws Exception;
	void delete(T dt) throws Exception;
	Collection<T> selectAll()  throws Exception;
	public int getNextId(T dt) throws Exception;
}
