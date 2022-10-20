package LeetCode.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathCrossing_1496 {
    public boolean isPathCrossing(String path) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('N', 1);
        map.put('E', 1);
        map.put('S', -1);
        map.put('W', -1);

        int y = 0;
        int x = 0;
        Set<String> set = new HashSet<>();
        set.add("0,0");
        for (char c : path.toCharArray()) {
            if (c == 'N' || c == 'S') {
                y += map.get(c);
            } else {
                x += map.get(c);
            }
            if (set.contains(y + "," + x))
                return true;

            set.add(y + "," + x);
        }

        return false;
    }
}
