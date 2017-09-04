import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import storage.SortedResumeStorage;

/**
 * Created by sergo on 30.08.2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ArrayStorageTest.class,
                SortedResumeStorageTest.class,
                ListStorageTest.class,
                MapUuidStorageTest.class,
                MapResumeStorageTest.class
        })
public class AllStorageTest {

}
