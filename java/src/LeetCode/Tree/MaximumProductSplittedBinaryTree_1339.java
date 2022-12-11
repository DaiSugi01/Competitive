package LeetCode.Tree;

public class MaximumProductSplittedBinaryTree_1339 {
    long maxSum;
    long sumOfNode;

    public int maxProduct(TreeNode root) {
        sumOfNode = sumOfTree(root);
        maxOfTree(root);
        return (int) (maxSum % (int) (Math.pow(10, 9) + 7));
    }

    private long maxOfTree(TreeNode node) {
        if (node == null) return 0;
        long currentSum = maxOfTree(node.left) + maxOfTree(node.right) + node.val;
        maxSum = Math.max(maxSum, currentSum * (sumOfNode - currentSum));
        return currentSum;
    }

    private int sumOfTree(TreeNode node) {
        if (node == null) return 0;
        int left = sumOfTree(node.left);
        int right = sumOfTree(node.right);

        return node.val + left + right;
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
