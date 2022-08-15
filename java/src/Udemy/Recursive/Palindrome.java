package Udemy.Recursive;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static void main(String[] args) {
        String word = "abccccdd";
        List<String> s = palindrome(word);
        s.sort((s1, s2) -> s2.length() - s1.length());
        System.out.println(s);
    }

    public static List<String> findPalindrome(String word, int left, int right) {
        List<String> res = new ArrayList<>();
        while (left >= 0 && right <= word.length() - 1) {
            if (word.toLowerCase().charAt(left) != word.toLowerCase().charAt(right))
                break;
            res.add(word.substring(left, right + 1));
            left--;
            right++;
        }
        return res;
    }

    public static List<String> palindrome(String word) {
        List<String> res = new ArrayList<>();
        int lenWord = word.length();
        if (lenWord == 0)
            return res;
        if (lenWord == 1)
            res.add(word);

        for (int i = 1; i < lenWord - 1; i++) {
            for (String s : findPalindrome(word, i - 1, i))
                res.add(s);

            for (String s : findPalindrome(word, i - 1, i + 1))
                res.add(s);
        }
        return res;
    }
}
