package sql;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by sergo on 23.10.2017.
 */
public interface SqlTransaction<T> {
    T execute(Connection conn) throws SQLException;
}
