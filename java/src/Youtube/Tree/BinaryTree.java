package Youtube.Tree;

import LeetCode.Tree.TreeUtils;
import LeetCode.Tree.Utuils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/*
    https://www.youtube.com/watch?v=fAAZixBzIAI
 */
public class BinaryTree {
    public static void main(String[] args) {
//        TreeNode<Character> root = new TreeNode<>('a');
//        root.left = new TreeNode<>('b');
//        root.left.left = new TreeNode<>('d');
//        root.left.right = new TreeNode<>('e');
//        root.right = new TreeNode<>('c');
//        root.right.left = new TreeNode<>('f');
//        System.out.println(searchBFS(root, 'e'));
//        System.out.println(searchBFS(root, 'z'));
//        System.out.println(searchBFSRec(root, 'e'));
//        System.out.println(searchBFSRec(root, 'z'));

        TreeNode<Integer> numRoot = TreeUtils.createNode();
//        System.out.println(treeSum(numRoot));
//        System.out.println(findSmallestNum(numRoot));
        System.out.println(maxRootToLeafSum(numRoot));

    }

    private static boolean searchBFS(TreeNode<Character> node, char target) {
        if (node == null)
            return false;

        Queue<TreeNode<Character>> q = new ArrayDeque<>();
        q.add(node);

        while (!q.isEmpty()) {
            TreeNode<Character> current = q.poll();
            if (current.val == target)
                return true;
            if (current.left != null) q.add(current.left);
            if (current.right != null) q.add(current.right);
        }

        return false;
    }

    private static boolean searchBFSRec(TreeNode<Character> node, char target) {
        if (node == null)
            return false;

        if (node.val == target) return true;
        return searchBFS(node.left, target) | searchBFS(node.right, target);
    }

    private static int treeSum(TreeNode<Integer> node) {
        if (node == null)
            return 0;

        return node.val + treeSum(node.left) + treeSum(node.right);
    }

    private static int findSmallestNum(TreeNode<Integer> node) {
        Stack<TreeNode<Integer>> stack = new Stack<>();

        int smallest = Integer.MAX_VALUE;
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode<Integer> current = stack.pop();
            smallest = Math.min(smallest, current.val);
            if (current.left != null)
                stack.push(current.left);

            if (current.right != null)
                stack.push(current.right);
        }

        return smallest;
    }

    private static int maxRootToLeafSum(TreeNode<Integer> node) {
        if (node.left == null && node.right == null)
            return node.val;

        int maxSum = Math.max(maxRootToLeafSum(node.left), maxRootToLeafSum(node.right));
        return node.val + maxSum;
    }
}
