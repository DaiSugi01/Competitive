package LeetCode.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumProductOfThreeNumbers_628 {
    public static void main(String[] args) {
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int numLength = nums.length;
        return Math.max(
                nums[0] * nums[1] * nums[numLength - 1],
                nums[numLength - 1] * nums[numLength - 2] * nums[numLength - 3]
        );
    }

    public int maximumProduct2(int[] nums) {
        if (nums.length < 3)
            return -1;

        PriorityQueue<Integer> pqLarge = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        for (int n : nums) {
            pqLarge.add(n);
            pqMin.add(n);
        }

        int maxNum = pqLarge.peek();
        int sum1 = 1;
        int sum2 = 1;
        for (int i = 0; i < 2; i++) {
            sum1 *= pqLarge.poll();
            sum2 *= pqMin.poll();
        }

        return Math.max(sum1 * pqLarge.peek(), sum2 * maxNum);
    }


}
