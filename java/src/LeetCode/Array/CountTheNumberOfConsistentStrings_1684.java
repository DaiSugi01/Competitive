//https://leetcode.com/problems/count-the-number-of-consistent-strings/description/
package LeetCode.Array;

public class CountTheNumberOfConsistentStrings_1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] chars = new int[26];
        for (char c : allowed.toCharArray())
            chars[c - 'a']++;

        int numOfConsistentStrings = words.length;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (chars[c - 'a'] <= 0) {
                    numOfConsistentStrings--;
                    break;
                }
            }
        }

        return numOfConsistentStrings;
    }
}
