package Interviewing.SF;

import java.util.HashMap;
import java.util.Map;

public class Q2 {
    public static void main(String[] args) {
        Q2 sol = new Q2();
        System.out.println(sol.StringScramble("world", "rkodqlw"));
        System.out.println(sol.StringScramble("rkodqlw", "world"));
    }

    public String StringScramble(String str1, String str2) {
        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : str1.toCharArray())
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);

        for (char c : str2.toCharArray()) {
            if (!charMap.containsKey(c) || charMap.get(c) <= 0) return "false";
            charMap.put(c, charMap.get(c) - 1);
        }

        return "true";
    }
}
