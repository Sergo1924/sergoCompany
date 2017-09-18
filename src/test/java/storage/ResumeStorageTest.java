package storage;

import java.io.IOException;

/**
 * Created by sergo on 30.08.2017.
 */
public class ResumeStorageTest extends AbstractArrayStorageTest {
    public ResumeStorageTest() throws IOException, InterruptedException {
        super(new ResumeStorage());
    }
}
