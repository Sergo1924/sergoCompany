package storage;

import storage.Serializer.XmlStreamSerializer;

/**
 * Created by sergo on 18.09.2017.
 */
public class XmlPathStorageTest extends AbstractStorageTest{
    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamSerializer()));
    }
}
