package LeetCode.Mock.Amazon;

import LeetCode.Tree.Utuils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q7 {
    public boolean findTarget(TreeNode<Integer> root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Set<Integer> set = new HashSet<>();
        for (int n : list) {
            if (set.contains(k - n)) {
                return true;
            }
            set.add(n);
        }

        return false;
    }

    private void inorder(TreeNode<Integer> node, List<Integer> list) {
        if (node == null) return;

        list.add(node.val);
        inorder(node.left, list);
        inorder(node.right, list);
    }

}
