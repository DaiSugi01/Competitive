package LeetCode.Mock.Amazon;

import LeetCode.Tree.Utuils.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Q15 {
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode<Integer> node, int k) {
        if (node == null) return false;

        if (set.contains(k - node.val))
            return true;

        set.add(node.val);
        boolean left = findTarget(node.left, k);
        boolean right = findTarget(node.left, k);

        return left || right;
    }

}
