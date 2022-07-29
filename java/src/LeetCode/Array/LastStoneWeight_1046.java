package LeetCode.Array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight_1046 {
    public static void main(String[] args) {

    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            if (s1 != s2) {
                pq.add((Math.abs(s1) - Math.abs(s2)));
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
