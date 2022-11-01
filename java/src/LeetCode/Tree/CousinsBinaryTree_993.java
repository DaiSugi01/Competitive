package LeetCode.Tree;

public class CousinsBinaryTree_993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] xNode = helper(root, x, root.val, 0);
        int[] yNode = helper(root, y, root.val, 0);
        if (xNode == null || yNode == null) return false;
        if (xNode[0] != yNode[0]) return false;
        return xNode[1] != yNode[1];
    }

    private int[] helper(TreeNode node, int target, int parent, int depth) {
        if (node == null) return null;
        if (node.val == target) return new int[]{depth, parent};

        int[] left = helper(node.left, target, node.val, depth + 1);
        if (left != null) return left;
        int[] right = helper(node.right, target, node.val, depth + 1);
        if (right != null) return right;

        return null;
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
