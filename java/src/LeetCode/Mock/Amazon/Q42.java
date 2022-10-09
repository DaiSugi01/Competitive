package LeetCode.Mock.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q42 {
    public String removeVowels(String s) {
        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        StringBuilder wordWithNoVowels = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!vowels.contains(c))
                wordWithNoVowels.append(c);
        }

        return wordWithNoVowels.toString();
    }
}
