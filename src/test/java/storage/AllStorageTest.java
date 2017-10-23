package storage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import storage.Serializer.DataStreamSerializer;

/**
 * Created by sergo on 30.08.2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                ListStorageTest.class,
                MapResumeStorageTest.class,
                ResumeStorageTest.class,
                SortedResumeStorageTest.class,
               // ObjectStreamPathStorage.class,
                ObjectStreamStorageTest.class,
                FileStorageTest.class,
                PathStorageTest.class,
                XmlPathStorageTest.class,
                JsonPathStorageTest.class,
                DataStreamSerializerTest.class,
                SqlStorageTest.class




        })
public class AllStorageTest {

}
