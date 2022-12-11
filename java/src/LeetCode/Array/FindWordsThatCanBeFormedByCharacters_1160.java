package LeetCode.Array;

public class FindWordsThatCanBeFormedByCharacters_1160 {
    int[] count;

    public int countCharacters(String[] words, String chars) {
        count = new int[26];
        for (char c : chars.toCharArray()) count[c - 'a']++;

        int ans = 0;
        for (String w : words) {
            if (isOK(w)) ans += w.length();
        }

        return ans;
    }

    private boolean isOK(String w) {
        int[] current = new int[26];
        for (char c : w.toCharArray()) current[c - 'a']++;
        for (int i = 0; i < 26; i++)
            if (current[i] > count[i]) return false;

        return true;
    }
}
