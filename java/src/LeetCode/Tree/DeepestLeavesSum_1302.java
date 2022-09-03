package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

public class DeepestLeavesSum_1302 {
    int maxDepth;
    int sum;

    public static void main(String[] args) {
        DeepestLeavesSum_1302 sol = new DeepestLeavesSum_1302();
        System.out.println(sol.deepestLeavesSum(TreeUtils.createNode()));
    }

    public int deepestLeavesSum(TreeNode<Integer> root) {
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode<Integer> node, int currentDepth) {
        if (node == null) return;

        if (currentDepth == maxDepth) {
            sum += node.val;
        } else if (currentDepth > maxDepth) {
            maxDepth = currentDepth;
            sum = node.val;
        }

        dfs(node.left, currentDepth + 1);
        dfs(node.right, currentDepth + 1);
    }
}
