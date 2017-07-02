import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sarasimonwillis-fleming on 12/12/16.
 */
public class ZipTest {

    @Test
    public void it_lists_its_contents() {

        InMemoryDirectory root = new InMemoryDirectory("koko");
        InMemoryDirectory directory = new InMemoryDirectory("pipo");
        InMemoryZip zip = new InMemoryZip("zip");

        root.add(directory);
        root.add(new InMemoryFile("t1", 10));
        directory.add(new InMemoryFile("t2", 5));
        directory.add(new InMemoryFile("t3", 8));


        assertEquals("pipo:[t2,t3]", directory.list());
        assertEquals("koko:[pipo:[t2,t3],t1]", root.list());
        assertEquals("zip:[koko:[pipo:[t2,t3],t1]]", zip.list());
    }
}
