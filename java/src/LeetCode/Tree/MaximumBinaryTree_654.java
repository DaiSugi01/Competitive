package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

import java.util.Arrays;

public class MaximumBinaryTree_654 {
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        if (nums.length == 0) return null;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree2(Arrays.copyOfRange(nums, 0, max));
        root.right = constructMaximumBinaryTree2(Arrays.copyOfRange(nums, max + 1, nums.length));

        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    public TreeNode helper(int[] nums, int l, int r) {
        if (l == r) return null;

        int max = max(nums, l, r);

        TreeNode root = new TreeNode(nums[max]);
        root.left = helper(nums, l, max);
        root.right = helper(nums, max + 1, r);

        return root;
    }

    public int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i])
                max_i = i;
        }
        return max_i;
    }
}
