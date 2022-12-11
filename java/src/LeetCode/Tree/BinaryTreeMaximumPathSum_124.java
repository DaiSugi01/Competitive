package LeetCode.Tree;

public class BinaryTreeMaximumPathSum_124 {
    int max = 0;

    public int maxPathSum(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        max = Math.max(max, node.val + left + right);

        return node.val + Math.max(left, right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
