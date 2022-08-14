package LeetCode.Tree.Utuils;

public class Tree {
    Tree() {
    }

    public static void printTree(TreeNode node) {
        if (node == null) return;

        printTree(node.left);
        System.out.print(node.val + " -> ");
        printTree(node.right);
    }
}
