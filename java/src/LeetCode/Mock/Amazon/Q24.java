package LeetCode.Mock.Amazon;

public class Q24 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (root.left != null && root.val < root.left.val)
            return false;
        else if (root.right != null && root.val > root.right.val)
            return false;

        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);

        return left || right;
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
