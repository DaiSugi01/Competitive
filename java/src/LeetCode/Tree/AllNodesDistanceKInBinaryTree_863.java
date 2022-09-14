package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllNodesDistanceKInBinaryTree_863 {
    List<Integer> res;
    TreeNode target;
    int k;

    public List<Integer> distanceK(TreeNode<Integer> root, TreeNode<Integer> target, int k) {
        this.target = target;
        this.k = k;
        res = new ArrayList<>();
        traversalTree(root);
        return res;
    }

    private int traversalTree(TreeNode<Integer> root) {
        if (root == null)
            return -1;

        if (root.val == target.val) {
            dfs(root, 0);
            return 1;
        }

        int l = traversalTree(root.left);
        int r = traversalTree(root.right);

        if (l >= 0) {
            if (l == k) res.add(root.val);
            dfs(root.right, l + 1);
            return l + 1;
        } else if (r >= 0) {
            if (r == k) res.add(root.val);
            dfs(root.left, r + 1);
            return r + 1;
        }

        return -1;
    }

    private void dfs(TreeNode<Integer> root, int depth) {
        if (root == null)
            return;

        if (depth == k) {
            res.add(root.val);
        } else {
            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
        }
    }
}
