package LeetCode.Mock.Amazon;

import java.util.Stack;

public class Q38 {
    public static void main(String[] args) {
        Q38 sol = new Q38();
        sol.find132pattern(new int[]{3, 5, 0, 3, 4});
    }

    /*
        input: [3,5,0,3,4]
        output: true (3, 5, 4)


        [3,3,0,0,0]
        [4]
     */
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j])
                    stack.pop();
                if (!stack.isEmpty() && stack.peek() < nums[j])
                    return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }
}
