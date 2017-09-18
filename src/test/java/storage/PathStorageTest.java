package storage;

import storage.Serializer.ObjectStreamSerializer;

/**
 * Created by sergo on 18.09.2017.
 */
public class PathStorageTest extends AbstractStorageTest{
    public PathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerializer()));
    }
}
