package CtCI.no_1_array_string;

import java.util.Arrays;

public class No2 {
    public static void main(String[] args) {
        System.out.println(permutation2("abcd", "aabc"));
        System.out.println(permutation2("abcd", "adbc"));
    }

    public static boolean myAnswer(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int charChecker1 = 0;
        int charChecker2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            int val = s1.charAt(i) - 'a';
            charChecker1 |= (1 << val);
            val = s2.charAt(i) - 'a';
            charChecker2 |= (1 << val);
        }

        return charChecker1 == charChecker2;
    }

    public static boolean permutation1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        return sort(s1).equals(sort(s2));
    }

    public static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static boolean permutation2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] letters = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i)] += 1;
        }

        for (int i = 0; i < s2.length(); i++) {
            letters[s2.charAt(i)] -= 1;
            if (letters[s2.charAt(i)] < 0) {
                return false;
            }
        }

        return true;
    }
}
