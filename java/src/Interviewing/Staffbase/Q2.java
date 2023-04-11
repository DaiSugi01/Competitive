package Interviewing.Staffbase;

import java.util.HashMap;
import java.util.Map;

public class Q2 {
    public static void main(String[] args) {
        Q2 sol = new Q2();
        String[][] inputs = new String[][]{
                new String[]{"world", "rkodqlw", "false"},
                new String[]{"rkodqlw", "world", "true"},
                new String[]{"rkodqlww", "world", "true"},
        };

        for (String[] in : inputs) {
            String str1 = in[0];
            String str2 = in[1];
            String expectedOutput = in[2];
            System.out.println(sol.StringScramble(str1, str2).equals(expectedOutput) ? "PASSED" : "Failed");
        }
    }

    public String StringScramble(String str1, String str2) {
        Map<Character, Integer> charMap = new HashMap<>();

        // build a hashMap based on str1 characters
        for (char c : str1.toCharArray())
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);

        // loop through str2, and return false if a character in the str2 does not exist in the hashMap or
        // it exists in the hashMap but value(frequency with which letters appear) is less than 0.
        for (char c : str2.toCharArray()) {
            if (!charMap.containsKey(c) || charMap.get(c) <= 0) return "false";
            charMap.put(c, charMap.get(c) - 1);
        }

        return "true";
    }
}
