package LeetCode.Mock.Amazon;

import java.util.ArrayList;
import java.util.List;

public class Q21 {
    private List<Integer> leafs = new ArrayList<>();

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return new ArrayList<>();

        leafs.add(root.val);
        helperLeft(root.left, true);
        helperRight(root.right, true);
        return leafs;
    }


    private boolean helperLeft(TreeNode node, boolean isBoundary) {
        if (node == null) return true;

        if (isBoundary)
            leafs.add(node.val);

        boolean left = helperLeft(node.left, isBoundary && node.left != null);
        boolean right = helperLeft(node.right, isBoundary && node.left == null);

        if (left && right && !isBoundary) {
            leafs.add(node.val);
        }

        return false;
    }

    private boolean helperRight(TreeNode node, boolean isBoundary) {
        if (node == null) return true;

        boolean left = helperRight(node.left, isBoundary && node.right == null);
        boolean right = helperRight(node.right, isBoundary);

        if (isBoundary)
            leafs.add(node.val);
        else if (left && right)
            leafs.add(node.val);

        return false;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
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
