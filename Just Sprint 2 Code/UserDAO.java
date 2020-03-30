import java.sql.SQLException;
import java.util.List;

public interface UserDAO<T> {
	void createTable()throws SQLException;
	void add(T t)throws SQLException;
	void update(T t)throws SQLException;
	void delete(String param)throws SQLException;
	T get(String param)throws SQLException;
	List<T> getAll()throws SQLException;
}
