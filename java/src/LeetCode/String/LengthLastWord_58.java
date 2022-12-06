package LeetCode.String;

public class LengthLastWord_58 {
    public int lengthOfLastWord(String s) {
        int p = s.length(), length = 0;
        while (p > 0) {
            p--;
            if (s.charAt(p) != ' ') {
                length++;
            } else if (length > 0) {
                return length;
            }
        }
        return length;
    }
}
