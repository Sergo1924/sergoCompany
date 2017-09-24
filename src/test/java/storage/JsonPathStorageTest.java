package storage;

import storage.Serializer.JsonStreamSerializer;

/**
 * Created by sergo on 21.09.2017.
 */
public class JsonPathStorageTest extends  AbstractStorageTest{
    public JsonPathStorageTest() {
        super(new PathStorage(AbstractStorageTest.STORAGE_DIR.getAbsolutePath(),new JsonStreamSerializer()));
    }
}
