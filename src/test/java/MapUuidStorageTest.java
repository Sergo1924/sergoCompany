import storage.MapUuidStorage;

import java.io.IOException;

/**
 * Created by sergo on 30.08.2017.
 */
public class MapUuidStorageTest extends AbstractStorageTest  {
    public MapUuidStorageTest() throws IOException, InterruptedException {
        super(new MapUuidStorage());
    }
}
