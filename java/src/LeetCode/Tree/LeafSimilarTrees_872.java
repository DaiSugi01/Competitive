package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees_872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        rec(root1, r1);
        List<Integer> r2 = new ArrayList<>();
        rec(root2, r2);

        if (r1.size() != r2.size()) return false;
        for (int i = 0; i < r1.size(); i++) {
            if (r1.get(i) != r2.get(i))
                return false;
        }
        return true;
    }

    private void rec(TreeNode root, List<Integer> leaf) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            leaf.add(root.val);
            return;
        }
        rec(root.left, leaf);
        rec(root.right, leaf);
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
