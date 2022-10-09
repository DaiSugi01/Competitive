package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode node, int targetSum, int currentSum, List<Integer> path) {
        if (node == null) return;

        path.add(node.val);
        currentSum += node.val;
        if (node.left == null && node.right == null && targetSum == currentSum) {
            res.add(List.copyOf(path));
            return;
        }

        dfs(node.left, targetSum, currentSum, path);
        dfs(node.right, targetSum, currentSum, path);

        path.remove(path.size() - 1);
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
