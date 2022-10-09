package LeetCode.Mock.Amazon;

import java.util.*;

public class Q41 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values())
            res.add(list);

        return res;
    }
}
