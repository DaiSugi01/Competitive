package LeetCode.Mock.Amazon;

public class Q8 {
    public static void main(String[] args) {
        Q8 sol = new Q8();
        System.out.println(sol.gcdOfStrings("AACCAACC", "AACC"));
    }

    /*
        Example 1:
        Input: str1 = "BCABC", str2 = "ABC"
        Output: "ABC"

        Example 2:
        Input: str1 = "ABABAB", str2 = "ABAB"
        Output: "AB"

        Example 3:
        Input: str1 = "LEET", str2 = "CODE"
        Output: ""
     */
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        } else if (!str1.startsWith(str2)) {
            return "";
        } else if (str2.length() == 0) {
            return str1;
        } else {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
    }
}
