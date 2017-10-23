package storage;

import storage.Serializer.DataStreamSerializer;
import storage.Serializer.JsonStreamSerializer;

/**
 * Created by sergo on 29.09.2017.
 */
public class DataStreamSerializerTest extends AbstractStorageTest {
    public DataStreamSerializerTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(),new DataStreamSerializer()));
    }
}
