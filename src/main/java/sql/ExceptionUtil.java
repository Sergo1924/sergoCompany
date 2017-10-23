package sql;

import exception.ExistStorageException;
import exception.StorageException;
import org.postgresql.util.PSQLException;

import java.security.spec.PSSParameterSpec;
import java.sql.SQLException;

/**
 * Created by sergo on 23.10.2017.
 */
public class ExceptionUtil {
    private ExceptionUtil() {
    }

    public static StorageException convertException(SQLException e){
        if (e instanceof PSQLException){
            if (e.getSQLState().equals("23505")){
                return  new ExistStorageException(null);
            }
        }
        return  new StorageException(e);
    }
}
