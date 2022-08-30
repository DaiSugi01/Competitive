package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

public class RangeSumBST_938 {
    public int rangeSumBST(TreeNode<Integer> root, int low, int high) {
        if (root == null)
            return 0;

        int sum = 0;
        if (root.val >= low)
            sum += rangeSumBST(root.left, low, high);
        if (root.val <= high)
            sum += rangeSumBST(root.right, low, high);

        if (root.val >= low && root.val <= high)
            return root.val + sum;
        else
            return sum;
    }
}
