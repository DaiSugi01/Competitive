package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

class Position {
    int freq;
    int start;
    int last;

    Position(int freq, int start, int last) {
        this.freq = freq;
        this.start = start;
        this.last = last;
    }
}

public class DegreeOfArray_697 {
    public static void main(String[] args) {
        findShortestSubArray(new int[]{2, 1});
    }

    /*
        Input: nums = [1,2,2,3,1]
        Output: 2

        maxDegree = INT_MAX
        posMap: {
            num: Position(freq, start, endpoint)
            1: (2, 0, 4),
            2: (2, 1, 2),
            3: (1, 3, 3)
        }

        minSubArrLength = MAX_INT
        if freq degree is equal to maxDegree
            minSubArrLength = MIN(minSubArrLength, pos[i][1] -pos[i][0] + 1)

     */
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Position> posMap = new HashMap<>();
        int maxDegree = 1;
        for (int i = 0; i < nums.length; i++) {
            if (!posMap.containsKey(nums[i])) {
                posMap.put(nums[i], new Position(1, i, i));
            } else {
                Position pos = posMap.get(nums[i]);
                pos.freq++;
                pos.last = i;
                maxDegree = Math.max(maxDegree, pos.freq);
            }
        }

        int minDegree = Integer.MAX_VALUE;
        for (Position p : posMap.values()) {
            if (p.freq == maxDegree) {
                minDegree = Math.min(minDegree, p.last - p.start + 1);
            }
        }

        return minDegree;
    }
}
