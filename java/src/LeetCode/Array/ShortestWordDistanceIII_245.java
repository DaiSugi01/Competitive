package LeetCode.Array;

public class ShortestWordDistanceIII_245 {
    /*
        Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
        Output: 1

        Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "makes"
        Output: 3

        stack = [1,2]

        [make, make, coding]
     */
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        long shortestPath = Integer.MAX_VALUE, w1 = shortestPath, w2 = -shortestPath;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1))
                w1 = i;
            if (wordsDict[i].equals(word2)) {
                if (word1.equals(word2))
                    w1 = w2;
                w2 = i;
            }
            shortestPath = Math.min(shortestPath, Math.abs(w1 - w2));
        }

        return (int) shortestPath;
    }
}
