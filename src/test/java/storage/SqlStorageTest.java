package storage;


import config.Config;

/**
 * Created by sergo on 03.10.2017.
 */
public class SqlStorageTest extends AbstractStorageTest {
    public SqlStorageTest() {
        super(Config.get().getStorage());
    }
}
