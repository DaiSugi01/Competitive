package LeetCode.String;

public class ValidAnagram_242 {
    public static void main(String[] args) {

    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }

        for (int num : table) {
            if (num != 0) return false;
        }

        return true;
    }
}
