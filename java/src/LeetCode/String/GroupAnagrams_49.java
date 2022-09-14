package LeetCode.String;

import java.util.*;

public class GroupAnagrams_49 {
    public static void main(String[] args) {
        GroupAnagrams_49 sol = new GroupAnagrams_49();
        sol.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }

        List<List<String>> ans = new ArrayList<>();
        for (List<String> list : map.values())
            ans.add(list);

        return ans;
    }
}
