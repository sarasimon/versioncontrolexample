import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sarasimonwillis-fleming on 12/12/16.
 */
public class DirectoryTest {

    @Test
    public void it_knows_its_size_when_is_empty() {
        MyResource directory = new InMemoryDirectory("koko");

        assertEquals(0, directory.size());
    }


    @Test
    public void it_knows_its_size_when_it_contains_files() {
        InMemoryDirectory directory = new InMemoryDirectory("koko");

        directory.add(new InMemoryFile("test", 5));
        directory.add(new InMemoryFile("test", 8));

        assertEquals(13, directory.size());
    }

    @Test
    public void it_knows_its_size_when_it_contains_directories_and_files() {
        InMemoryDirectory root = new InMemoryDirectory("koko");
        InMemoryDirectory directory = new InMemoryDirectory("pipo");

        root.add(directory);
        root.add(new InMemoryFile("t1", 10));
        directory.add(new InMemoryFile("t2", 5));
        directory.add(new InMemoryFile("t3", 8));

        assertEquals(13, directory.size());
        assertEquals(23, root.size());
    }

}
