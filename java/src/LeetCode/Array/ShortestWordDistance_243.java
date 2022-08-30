package LeetCode.Array;

public class ShortestWordDistance_243 {
    public static void main(String[] args) {
    }

    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int minDis = Integer.MAX_VALUE;
        int idx1 = -1;
        int idx2 = -1;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1))
                idx1 = i;
            if (wordsDict[i].equals(word2))
                idx2 = i;

            if (idx1 != -1 && idx2 != -1) {
                minDis = Math.min(minDis, Math.abs(idx1 - idx2));
            }
        }
        return minDis;
    }
}
