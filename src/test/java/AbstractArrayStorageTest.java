import exception.StorageException;
import model.Resume;
import org.junit.Assert;
import org.junit.Test;
import storage.AbstractArrayStorage;
import storage.Storage;

/**
 * Created by sergo on 30.08.2017.
 */
public class AbstractArrayStorageTest extends AbstractStorageTest{
    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Name" + i));
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume("Overflow"));
    }
}
