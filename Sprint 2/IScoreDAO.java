import java.sql.SQLException;
import java.util.List;

public interface IScoreDAO<T> {
	void createTable() throws SQLException;
	void save(T t) throws SQLException;
	List<T> getAll() throws SQLException;
	List<T> getAll(String param) throws SQLException;
}
