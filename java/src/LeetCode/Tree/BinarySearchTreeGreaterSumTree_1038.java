package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

public class BinarySearchTreeGreaterSumTree_1038 {
    int sum;

    public TreeNode<Integer> bstToGst(TreeNode<Integer> root) {
        if (root == null) return null;

        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);

        return root;
    }
}
