package LeetCode.Tree;

import LeetCode.Tree.Utuils.Tree;
import LeetCode.Tree.Utuils.TreeNode;

public class ConvertSortedArrayToBinarySearchTree_108 {

    static int[] nums;

    public static void main(String[] args) {
        nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode tree = sortedArrayToBST(nums);
        Tree.printTree(tree);
        String a = "A";
        System.out.println(a.hashCode() >>> 16);
    }

    public static TreeNode helper(int left, int right) {
        if (left > right) return null;

        // always choose left middle node as a root
        int p = (left + right) / 2;

        // preorder traversal: node -> left -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length - 1);
    }
}
