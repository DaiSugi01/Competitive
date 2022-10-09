package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class TotalAppealOfAString_2262 {
    public static void main(String[] args) {
        TotalAppealOfAString_2262 sol = new TotalAppealOfAString_2262();
        System.out.println(sol.appealSum("abbca"));
        System.out.println(sol.appealSum("code"));
    }

    public long appealSum(String s) {
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                ans += map.size();
            }
        }

        return ans;
    }
}
