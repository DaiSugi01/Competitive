package LeetCode.Array;

import java.util.Stack;

public class BuildingsWithOceanView_1762 {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (heights[i] > heights[stack.peek()]) {
                stack.push(i);
            }
        }

        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        
        return res;
    }
}
