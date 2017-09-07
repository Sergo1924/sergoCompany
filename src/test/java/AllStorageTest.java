import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import storage.AbstractArrayStorage;
import storage.SortedResumeStorage;

/**
 * Created by sergo on 30.08.2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ListStorageTest.class,
                MapUuidStorageTest.class,
                MapResumeStorageTest.class,
                ResumeStorageTest.class,
                SortedResumeStorageTest.class


        })
public class AllStorageTest {

}
