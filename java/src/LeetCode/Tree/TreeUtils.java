package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

public class TreeUtils<T> {

    public <T> TreeUtils() {
    }

    public static TreeNode createNode() {
        TreeNode<Integer> root = new TreeNode<Integer>(3);
        root.left = new TreeNode<>(9);
        root.right = new TreeNode<>(20);
        root.right.left = new TreeNode<>(15);
        root.right.right = new TreeNode<>(1);
        root.right.right.right = new TreeNode<>(4);
        return root;
    }

    public static TreeNode createBST(int[] nodes) {
        TreeNode<Integer> root = new TreeNode<Integer>(3);
        root.left = new TreeNode<>(9);
        root.right = new TreeNode<>(20);
        root.right.left = new TreeNode<>(15);
        root.right.right = new TreeNode<>(1);
        return root;
    }
}
