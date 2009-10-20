package dao;
import java.util.Collection;

/**
 * This interface defined the basic activities that must be implemented by all DAO objects
 * @author Samarjit Samanta
 * @param <T> T is the template class of corresponding DTO
 */
public interface PropDAO<T> {
	 T select(T dt)  throws Exception;
	void update(T dt) throws Exception;
	void insert(T dt) throws Exception;
	void delete(T dt) throws Exception;
	Collection<T> selectAll()  throws Exception;
	public int getNextId(T dt) throws Exception;
}
