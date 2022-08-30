package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

public class SearchInBinarySearchTree_700 {
    public TreeNode<Integer> searchBST(TreeNode<Integer> root, int val) {
        if (root == null || val == root.val)
            return root;

        return val < root.val ?
                searchBST(root.left, val) :
                searchBST(root.right, val);
    }
}
