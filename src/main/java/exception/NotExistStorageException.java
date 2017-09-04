package exception;

/**
 * Created by sergo on 30.08.2017.
 */
public class NotExistStorageException  extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Resume " + uuid + " not exist", uuid);
    }
}
