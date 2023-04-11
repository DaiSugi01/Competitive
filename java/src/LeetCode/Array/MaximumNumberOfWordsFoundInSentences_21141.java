//https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
package LeetCode.Array;

public class MaximumNumberOfWordsFoundInSentences_21141 {
    public int mostWordsFound(String[] sentences) {
        int maxWordCount = 0;
        for (int i = 0; i < sentences.length; i++) {
            maxWordCount = Math.max(sentences[i].split(" ").length, maxWordCount);
        }

        return maxWordCount;
    }
}
