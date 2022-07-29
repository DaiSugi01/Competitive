package LeetCode.Array;

import java.util.PriorityQueue;

public class KthLargestElementInArray_215 {
    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 -n2);

        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();
    }
}
