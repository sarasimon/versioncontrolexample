import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarasimonwillis-fleming on 12/12/16.
 */
public class InMemoryDirectory implements MyResource {
    List<MyResource> myResourceList;
    private String name;

    public InMemoryDirectory(String name) {
        myResourceList = new ArrayList<MyResource>();
        this.name = name;
    }

    public int size() {
        int size = 0;
        for (MyResource resource: myResourceList) {
            size += resource.size();
        }
        return size;
    }

    public void add(MyResource resource) {
        myResourceList.add(resource);
    }
}
