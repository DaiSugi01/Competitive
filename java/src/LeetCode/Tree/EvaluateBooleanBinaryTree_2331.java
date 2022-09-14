package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

public class EvaluateBooleanBinaryTree_2331 {
    public boolean evaluateTree(TreeNode<Integer> root) {
        int ans = helper(root);
        return ans == 1;
    }

    public int helper(TreeNode<Integer> root) {
        if (root == null)
            return 0;

        int left = helper(root.left);
        int right = helper(root.right);
        if (root.val == 2) {
            return left | right;
        }
        if (root.val == 3) {
            return left & right;
        }

        return root.val;
    }
}
