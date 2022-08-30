package LeetCode.DP;

public class IsSubsequence_392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
    }

    /*
        Input: s = "abc", t = "ahbgdc"
        Output: true
     */
    public static boolean isSubsequence(String s, String t) {
        int ps = 0;
        int pt = 0;
        while (ps < s.length() && pt < t.length()) {
            if (s.charAt(ps) == t.charAt(pt)) {
                ps++;
            }
            pt++;
        }

        return ps == s.length();
    }
}
