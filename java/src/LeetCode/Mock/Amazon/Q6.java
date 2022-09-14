package LeetCode.Mock.Amazon;

public class Q6 {
    public static void main(String[] args) {
        Q6 sol = new Q6();
        System.out.println(sol.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > res.length())
                    res = s.substring(l, r + 1);
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > res.length())
                    res = s.substring(l, r + 1);
                l--;
                r++;
            }
        }

        return res;
    }
}
