package LeetCode.Mock.Amazon;

import java.util.HashMap;
import java.util.Map;

public class Q33 {
    public static void main(String[] args) {
        Q33 sol = new Q33();
        System.out.println(sol.lengthOfLongestSubstring("aab"));
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
    }

    /*
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.

        {
            a: 1,
            b: 2,
            c: 3,
        }

     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxFreq = 0;
        int end;
        for (end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                maxFreq = Math.max(maxFreq, end - start);
                start = Math.max(map.get(s.charAt(start)), end);
            }
            maxFreq = Math.max(maxFreq, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }

        return maxFreq;
    }
}
