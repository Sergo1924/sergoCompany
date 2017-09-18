package storage;

import storage.Serializer.ObjectStreamSerializer;

/**
 * Created by sergo on 18.09.2017.
 */
public class FileStorageTest extends AbstractStorageTest{
    public FileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectStreamSerializer()));
    }
}
