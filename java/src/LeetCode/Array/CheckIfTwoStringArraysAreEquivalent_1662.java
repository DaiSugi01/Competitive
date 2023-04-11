//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/
package LeetCode.Array;

public class CheckIfTwoStringArraysAreEquivalent_1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}
