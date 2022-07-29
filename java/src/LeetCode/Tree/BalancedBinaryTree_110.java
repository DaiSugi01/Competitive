package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

public class BalancedBinaryTree_110 {
    final class TreeInfo {
        public final int height;
        public final boolean balanced;

        public TreeInfo(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    public TreeInfo helper(TreeNode root) {
        if (root == null) {
            return new TreeInfo(-1, true);
        }

        TreeInfo left = helper(root.left);
        if (!left.balanced) {
            return new TreeInfo(-1, false);
        }
        TreeInfo right = helper(root.right);
        if (!right.balanced) {
            return new TreeInfo(-1, false);
        }

        if (Math.abs(left.height - right.height) <= 1) {
            return new TreeInfo(Math.max(left.height, right.height) + 1, true);
        }

        return new TreeInfo(-1, false);
    }

    public boolean isBalanced(TreeNode root) {
        return helper(root).balanced;
    }

    public static void main(String[] args) {

    }
}
