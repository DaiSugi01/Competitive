package LeetCode.Tree;

public class BinaryTreePruning_814 {
    public TreeNode pruneTree(TreeNode root) {
        return helper(root);
    }

    private TreeNode helper(TreeNode node) {
        if (node == null) return null;

        node.left = helper(node.left);
        node.right = helper(node.right);

        return node.left == null && node.right == null &&
                node.val == 0 ? null : node;
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
