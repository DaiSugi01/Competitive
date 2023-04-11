// https://leetcode.com/problems/truncate-sentence/description/
package LeetCode.Array;

public class TruncateSentence_1816 {
    public String truncateSentence(String s, int k) {
        StringBuilder truncatedSentence = new StringBuilder();
        String[] splittedStr = s.split(" ");
        for (int i = 0; i < k; i++) {
            truncatedSentence.append(splittedStr[i] + " ");
        }

        return truncatedSentence.toString().trim();
    }
}
