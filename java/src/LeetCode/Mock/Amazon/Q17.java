/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
package LeetCode.Mock.Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Q17 {
    private String orgString;
    private List<String> res;
    private Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        res = new ArrayList<>();
        orgString = digits;
        helper(new StringBuffer(), 0);
        return res;
    }

    /*
        base case: current letters length == digits lengths
            add current letters to res array

     */
    public void helper(StringBuffer digits, int idx) {
        if (digits.length() == orgString.length()) {
            res.add(digits.toString());
            return;
        }

        String letter = letters.get(orgString.charAt(idx));
        for (char c : letter.toCharArray()) {
            digits.append(c);
            helper(digits, idx + 1);
            digits.deleteCharAt(digits.length() - 1);
        }
    }
}
