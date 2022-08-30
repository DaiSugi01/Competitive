package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

public class RootEqualsSumChildren_2236 {
    public boolean checkTree(TreeNode<Integer> root) {
        return root.val == root.left.val + root.right.val;
    }
}
