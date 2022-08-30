package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

public class FindCorrespondingNodeOfBinaryTreeInCloneThatTree_1379 {
    TreeNode ans;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
//        inorder(original, cloned, target);
//        return ans;
        if (original == null)
            return null;

        if (original == target)
            return cloned;

        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        if (left == null && right == null)
            return null;

        return right == null ? left : right;
    }

    private void inorder(TreeNode o, TreeNode c, TreeNode target) {
        if (o == null)
            return;

        inorder(o.left, c.left, target);
        if (o == target) {
            this.ans = c;
            return;
        }
        inorder(o.right, c.right, target);
    }
}
