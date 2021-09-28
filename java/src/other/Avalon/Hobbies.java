package other.Avalon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Hobbies {
    private final HashMap<String, String[]> hobbies = new HashMap<String, String[]>();

    public void add(String hobbyist, String... hobbies) {
        this.hobbies.put(hobbyist, hobbies);
    }

    public List<String> findAllHobbyists(String hobby) {
        ArrayList<String> res = new ArrayList<String>();
        for (String name: this.hobbies.keySet()) {
            if (Arrays.asList(this.hobbies.get(name)).contains(hobby)) {
                res.add(name);
            };
        }

        return res;
    }
}
