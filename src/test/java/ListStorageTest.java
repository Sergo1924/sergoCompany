import storage.ListStorage;

import java.io.IOException;

/**
 * Created by sergo on 30.08.2017.
 */
public class ListStorageTest extends AbstractStorageTest {
    public ListStorageTest() throws IOException, InterruptedException {
        super(new ListStorage());
    }
}
