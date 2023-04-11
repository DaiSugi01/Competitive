//https://leetcode.com/problems/rings-and-rods/description/
package LeetCode.String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RingsAndRods_2103 {
    /*
        Input: rings = "B0B6G0R6R0R6G9"
        Output: 1
     */
    public int countPoints(String rings) {
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int rod = rings.charAt(i + 1) - '0';
            Set<Character> l = map.getOrDefault(rod, new HashSet<>());
            l.add(color);
            map.put(rod, l);
        }

        int rods = 0;
        for (Map.Entry<Integer, Set<Character>> m : map.entrySet()) {
            rods += m.getValue().size() == 3 ? 1 : 0;
        }

        return rods;
    }
}
