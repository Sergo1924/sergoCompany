package sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by sergo on 23.10.2017.
 */
public interface SqlExecutor<T> {
    T execute(PreparedStatement st) throws SQLException;
}
