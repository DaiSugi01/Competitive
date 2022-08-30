package LeetCode.String;

public class CountBinarySubstrings_696 {
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("110001111000000"));
    }

    /*
        Input: s = "110001111000000"
        Output: 9
     */
    public static int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int numOfGroup = 0;
        groups[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                groups[numOfGroup]++;
            } else {
                groups[++numOfGroup] = 1;
            }
        }

        int ans = 0;
        for (int i = 1; i <= numOfGroup; i++) {
            ans += Math.min(groups[i], groups[i - 1]);
        }

        return ans;
    }
}
