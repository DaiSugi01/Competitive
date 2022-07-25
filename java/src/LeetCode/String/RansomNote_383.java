package LeetCode.String;

public class RansomNote_383 {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] table = new int[26];
        for (char c : magazine.toCharArray()) {
            table[c - 'a'] += 1;
        }

        for (char c : ransomNote.toCharArray()) {
            int idx = c - 'a';
            table[idx]--;
            if (table[idx] < 0) return false;
        }

        return true;
    }
}
