package storage;

import java.io.IOException;

/**
 * Created by sergo on 30.08.2017.
 */
public class SortedResumeStorageTest extends AbstractArrayStorageTest {
    public SortedResumeStorageTest() throws IOException, InterruptedException {
       super(new SortedResumeStorage());
    }
}
