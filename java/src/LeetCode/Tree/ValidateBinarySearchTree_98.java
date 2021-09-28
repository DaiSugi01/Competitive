package LeetCode.Tree;

public class ValidateBinarySearchTree_98 {

//     Definition for a binary tree node.
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    private Integer prev;

    public boolean isValidBST(TreeNode root) {
//        return inorder(root, null, null);
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) return true;

        if (!inorder(root.left)) return false;

        if (prev != null && root.val <= prev) return false;

        prev = root.val;
        return inorder(root.right);
    }

     private boolean inorder(TreeNode root, Integer low, Integer high) {
         if (root == null) return true;

         if (low != null && root.val <= low ||
             high != null && root.val >= high) {
             return false;
         }

         return (inorder(root.left, low, root.val) && inorder(root.right, root.val, high));
     }
}
