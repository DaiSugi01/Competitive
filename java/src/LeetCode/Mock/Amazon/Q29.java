package LeetCode.Mock.Amazon;

import java.util.ArrayList;
import java.util.List;

public class Q29 {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    public boolean isSymmetric(TreeNode root) {
        preorder(root.left);
        postorder(root.right);

        List<Integer> l1 = list1;
        List<Integer> l2 = list2;
        if (list1.size() != list2.size()) return false;

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) return false;
        }
        return true;
    }

    private void postorder(TreeNode node) {
        if (node == null) {
            list2.add(-1);
            return;
        }

        list2.add(node.val);
        postorder(node.right);
        postorder(node.left);
    }

    private void preorder(TreeNode node) {
        if (node == null) {
            list1.add(-1);
            return;
        }

        list1.add(node.val);
        preorder(node.left);
        preorder(node.right);
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
