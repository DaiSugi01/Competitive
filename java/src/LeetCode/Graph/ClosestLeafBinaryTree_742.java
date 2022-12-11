package LeetCode.Graph;

import java.util.*;

public class ClosestLeafBinaryTree_742 {
    Map<TreeNode, List<TreeNode>> adjMap;

    public int findClosestLeaf(TreeNode root, int k) {
        adjMap = new HashMap<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        buildGraph(root, null, q, k);
        Set<TreeNode> visited = new HashSet<>();
        Map<TreeNode, List<TreeNode>> a = adjMap;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null && node.left == null && node.right == null) return node.val;
            for (TreeNode v : adjMap.get(node)) {
                if (visited.contains(v)) continue;
                if (v == null) continue;
                q.add(v);
                visited.add(v);
            }
        }

        return -1;
    }

    private void buildGraph(TreeNode node, TreeNode parent, Queue<TreeNode> q, int k) {
        if (node == null) return;
        if (node.val == k) q.add(node);

        adjMap.putIfAbsent(node, new ArrayList<>());
        adjMap.putIfAbsent(parent, new ArrayList<>());
        adjMap.get(node).add(parent);
        adjMap.get(parent).add(node);
        buildGraph(node.left, node, q, k);
        buildGraph(node.right, node, q, k);
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
