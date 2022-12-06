package LeetCode.String;

public class SingleRowKeyboard_1165 {
    public int calculateTime(String keyboard, String word) {
        int[] places = new int[26];
        for (int i = 0; i < keyboard.length(); i++)
            places[keyboard.charAt(i) - 'a'] = i;

        int dist = 0;
        int prevPlace = 0;
        for (char c : word.toCharArray()) {
            dist += Math.abs(prevPlace - places[c - 'a']);
            prevPlace = places[c - 'a'];
        }

        return dist;
    }
}
