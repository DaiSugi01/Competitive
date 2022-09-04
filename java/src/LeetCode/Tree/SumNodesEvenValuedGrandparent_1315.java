package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

public class SumNodesEvenValuedGrandparent_1315 {
    int res;

    public int sumEvenGrandparent(TreeNode<Integer> root) {
        dfs(root, false, false);
        return res;
    }

    public void dfs(TreeNode<Integer> root, boolean p, boolean g) {
        if (root == null) return;

        if (g)
            res += root.val;

        dfs(root.left, root.val % 2 == 0, p);
        dfs(root.right, root.val % 2 == 0, p);
    }
}
