package storage;

import java.io.IOException;

/**
 * Created by sergo on 30.08.2017.
 */
public class MapResumeStorageTest extends AbstractStorageTest {
    public MapResumeStorageTest() throws IOException, InterruptedException {
        super(new MapResumeStorage());
    }
}
