package LeetCode.Mock.Amazon;

import LeetCode.Tree.Utuils.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Q4 {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        traverse(root1, set1);
        traverse(root2, set2);

        for (int n : set1) {
            if (set2.contains(n - target) || set2.contains(target - n)) {
                return true;
            }
        }

        return false;
    }

    private void traverse(TreeNode<Integer> root, Set<Integer> set) {
        if (root == null) return;
        set.add(root.val);
        traverse(root.left, set);
        traverse(root.right, set);
    }
}
