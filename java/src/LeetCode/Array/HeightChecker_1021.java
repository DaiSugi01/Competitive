package LeetCode.Array;

import java.util.Arrays;

public class HeightChecker_1021 {

    /*
        Input: heights = [1,1,4,2,1,3]
        bucket=[0,3,1,1,1]

        int expectedHeight = 1;
        loop thorough a heights array
            increment expectedHeights variable to track the expected height
            while (bucket[expectedHeight] == 0)
                expectedHeight++;
     */
    public int heightChecker2(int[] heights) {
        final int[] bucket = new int[101];
        for (int h : heights) {
            bucket[h]++;
        }

        int expectedHeight = 1;
        int outOfOrder = 0;
        for (int i = 0; i < heights.length; i++) {
            while (bucket[expectedHeight] == 0) {
                expectedHeight++;
            }
            if (expectedHeight != heights[i]) {
                outOfOrder++;
            }
            bucket[expectedHeight]--;
        }
        return outOfOrder;
    }

    public int heightChecker(int[] heights) {
        final int[] expectedHeights = heights.clone();
        Arrays.sort(expectedHeights);
        int outOfOrder = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] != expectedHeights[i]) {
                outOfOrder++;
            }
        }

        return outOfOrder;
    }
}
