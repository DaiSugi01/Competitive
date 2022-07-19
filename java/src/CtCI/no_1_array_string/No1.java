package CtCI.no_1_array_string;

public class No1 {

    public static void main(String[] args) {
        No1IsUniqueChars2("zabz");
    }

    public static boolean No1IsUniqueChars1(String s) {
        boolean[] charSet = new boolean[128];

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (charSet[val]) {
                return false;
            }

            charSet[val] = true;
        }

        return true;
    }

    public static boolean No1IsUniqueChars2(String s) {
        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            if ((checker & 1 << val) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }
}
