package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

import static LeetCode.Tree.TreeUtils.createNode;

public class MaximumDepthBinaryTree_104 {
    public static void main(String[] args) {
        System.out.println(maxDepth(createNode()));
    }

    public static int maxDepth(TreeNode<Integer> node) {
        if (node == null) return 0;

        int left = maxDepth(node.left) + 1;
        int right = maxDepth(node.right) + 1;

        return Math.max(left, right);
    }
}
