package Interviewing.SF;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public static void main(String[] args) {
        Q1 sol = new Q1();
        System.out.println(sol.StringScramble());
    }

    public boolean StringScramble(String str1, String str2) {
        Map<Character, Integer> charMap = new HashMap<>();
        String shortString;
        String largeString;
        if (str1.length() > str2.length()) {
            shortString = str2;
            largeString = str1;
        } else {
            shortString = str1;
            largeString = str2;
        }

        for (char c : largeString.toCharArray())
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);

        for (int i = 0; i < shortString.length(); i++) {
            chars[shortString.charAt(i) - 'a'] -= 1;
            if (chars[shortString.charAt(i) - 'a'] < 0)
                return false;
        }

        return true;
    }
}
