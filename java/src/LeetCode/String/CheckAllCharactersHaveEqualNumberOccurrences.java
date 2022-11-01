package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class CheckAllCharactersHaveEqualNumberOccurrences {
    public boolean areOccurrencesEqual(String s) {
        if (s.length() == 0) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int counter = map.get(s.charAt(0));
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (m.getValue() != counter)
                return false;
        }

        return true;
    }
}
