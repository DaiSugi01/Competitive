// https://leetcode.com/problems/sort-the-people/description/
package LeetCode.Array;

import java.util.Map;
import java.util.TreeMap;

public class SortThePeople_2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> treeMap = new TreeMap<>();
        int n = names.length;
        for (int i = 0; i < n; i++) {
            treeMap.put(heights[i], names[i]);
        }

        String[] res = new String[n];
        int p = n - 1;
        for (Map.Entry<Integer, String> m : treeMap.entrySet()) {
            res[p--] = m.getValue();
        }

        return res;
    }
}
