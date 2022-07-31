package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class temp {
    public static void main(String[] args) {

    }

    /*
        Input: stones = [2,7,4,1,8,1]
        Output: 1

        Use pq -> [4,2,1,1]
        loop through pq while (pq size > 1):
            largeVal = pq.poll();   -> 8
            smallVal = pq.poll();   -> 7
            if (largeVal != smallVal):
                add largeVal - smallVal to pq

        return pq.poll() if pq is not empty, otherwise return 0

     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int largeVal = pq.poll();
            int smallVal = pq.poll();
            if (largeVal != smallVal) {
                pq.add(largeVal - smallVal);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
