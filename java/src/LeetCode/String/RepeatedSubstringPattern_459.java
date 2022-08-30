package LeetCode.String;

public class RepeatedSubstringPattern_459 {
    public static void main(String[] args) {
        System.out.println(stringSearching("ABCDABABC", "ABCDE"));
    }

    /*
        text:    ABCDABABC
        pattern: ABCDE

        ABABABC
          t
        ABC
          p
     */
    private static int stringSearching(String text, String pattern) {
        int pt = 0;
        int pp = 0;
        while (pt < text.length() && pp < pattern.length()) {
            if (text.charAt(pt) == pattern.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        if (pp == pattern.length()) {
            return pt - pp;
        }

        return -1;
    }

    /*
        Input: s = "abab"
        Output: true
     */
    public boolean repeatedSubstringPattern(String s) {
//        int j = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == s.charAt())
//                j++;
//        }
        return true;
    }
}
