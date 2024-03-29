package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

import java.util.ArrayList;

public class SymmetricTree_101 {
    static ArrayList<Integer> list1;
    static ArrayList<Integer> list2;

    public static void main(String[] args) {

    }

    private static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;

        return (node1.val == node2.val) &&
                isMirror(node1.left, node2.right) &&
                isMirror(node1.right, node2.left);
    }
}
