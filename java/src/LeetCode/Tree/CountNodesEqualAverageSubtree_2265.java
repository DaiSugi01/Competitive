package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

public class CountNodesEqualAverageSubtree_2265 {
    int res = 0;

    public int averageOfSubtree(TreeNode<Integer> root) {
        dfs(root);
        return res;
    }

    public Pair dfs(TreeNode<Integer> node) {
        if (node == null) return new Pair(0, 0);

        Pair left = dfs(node.left);
        Pair right = dfs(node.right);

        int sum = left.sum + right.sum + node.val;
        int numOfNode = left.nodes + right.nodes + 1;
        if (sum / numOfNode == node.val)
            res++;

        return new Pair(numOfNode, sum);
    }

    class Pair {
        int nodes;
        int sum;

        public Pair(int nodes, int sum) {
            this.nodes = nodes;
            this.sum = sum;
        }
    }
}
