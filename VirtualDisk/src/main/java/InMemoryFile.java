/**
 * Created by sarasimonwillis-fleming on 12/12/16.
 */
public class InMemoryFile implements MyResource {
    private final String name;
    private final int size;

    public InMemoryFile(String name, int size) {

        this.name = name;
        this.size = size;
    }

    public int size() {
        return size;
    }
}
