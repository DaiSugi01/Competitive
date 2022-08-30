package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class CheckWhetherTwoStringsAlmostEquivalent_2068 {
    public static void main(String[] args) {
        String word1 = "zzzyyy";
        String word2 = "iiiiii";
        System.out.println(checkAlmostEquivalent(word1, word2));
    }

    public static boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            map.put(word1.charAt(i), map.getOrDefault(word1.charAt(i), 0) + 1);
            map.put(word2.charAt(i), map.getOrDefault(word2.charAt(i), 0) - 1);
        }

        for (int val : map.values()) {
            if (Math.abs(val) > 3) return false;
        }
        return true;
    }
}
