package LeetCode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsLargeGroups_830 {
    /*
        baaa
        input:  abcdddeeeeaabbbcd
        output: [[3,5],[6,9],[12,14]]
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        int i = 0, j = 1;
        List<List<Integer>> res = new ArrayList<>();
        while (j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                if (j - i >= 3)
                    res.add(Arrays.asList(i, j - 1));
                i = j;
            }
            j++;
        }

        if (j - i >= 3)
            res.add(Arrays.asList(i, j - 1));

        return res;
    }
}
