package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_496 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        int[] ans = nextGreaterElement2(nums1, nums2);
        for (int a : ans) {
            System.out.print(a);
            System.out.print(",");
        }
    }

    /*
        map {
            1: 3,
            3: 4,
        }

        stack=[2,]
        loop through nums2 array
            loop through while stack is not empty nums2[i] > the top element of the stack
                map.put(nums2[i], stack.pop())
            push the num to stack
     */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek())
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }

        while (!stack.empty())
            map.put(stack.pop(), -1);

        System.out.println(map);

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    /*
        Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
        Output: [-1,3,-1]

        create a hash map to sotre the index of the nums in nums2 array
        {
            1: 0,
            3: 1
            4: 2
            2: 3
        }
        loop through nums1
            get the index of the num in nums2
            loop through while (the index < nums2.length)
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            indexMap.put(nums2[i], i);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int maxNum = -1;
            for (int j = indexMap.get(nums1[i]) + 1; j < nums2.length; j++) {
                if (nums2[j] > nums1[j]) {
                    maxNum = nums2[j];
                    break;
                }
            }
            ans[i] = maxNum;
        }
        return ans;
    }
}
