package LeetCode.Greedy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome_409 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

        int ans = 0;
        for (int v : map.values()) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
}
