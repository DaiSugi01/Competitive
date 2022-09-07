package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST_230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = inorder(root, new ArrayList<>());

        return nums.get(k - 1);
    }

    private List<Integer> inorder(TreeNode<Integer> root, List<Integer> nums) {
        if (root == null) return nums;

        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);

        return nums;
    }
}
