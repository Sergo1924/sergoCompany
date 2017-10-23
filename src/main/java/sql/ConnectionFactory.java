package sql;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by sergo on 29.09.2017.
 */
public interface ConnectionFactory {
    Connection getConnection() throws SQLException;
}
