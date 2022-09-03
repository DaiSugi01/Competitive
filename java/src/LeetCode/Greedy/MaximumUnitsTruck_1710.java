package LeetCode.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumUnitsTruck_1710 {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                new int[]{5, 10},
                new int[]{2, 5},
                new int[]{4, 7},
                new int[]{3, 9}
        };
        System.out.println(maximumUnits(input, 10));
    }

    /*
        Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
        Output: 91

        units  [10,9, 7] = 50 + 27 + 14 = 91
        #boxes [5, 3, 2]
        Use PriorityQueue to sort boxTypes based on the 2nd item
        loop through the queue and poll the item
            if the #boxes is <= truckSize
                res += unit * boxes
     */
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> n2[1] - n1[1]);
        pq.addAll(Arrays.asList(boxTypes));
        while (!pq.isEmpty()) {
            int[] boxType = pq.poll();
            int boxCount = Math.min(boxType[0], truckSize);
            res += boxCount * boxType[1];
            truckSize -= boxCount;
            if (truckSize == 0)
                break;
        }

        return res;
    }
}
