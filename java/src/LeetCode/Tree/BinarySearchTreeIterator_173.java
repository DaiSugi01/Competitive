package LeetCode.Tree;

import LeetCode.Tree.Utuils.TreeNode;

import java.util.ArrayList;

public class BinarySearchTreeIterator_173 {
    public static void main(String[] args) {
        int a = 0;
        System.out.println(a++);
    }

    class BSTIterator {

        public int current;
        public ArrayList<Integer> nodeSorted;

        public BSTIterator(TreeNode<Integer> root) {
            nodeSorted = new ArrayList<>();
            current = 0;
            inOrder(root);
        }

        public int next() {
            return nodeSorted.get(++current);
        }

        private void inOrder(TreeNode<Integer> node) {
            if (node == null)
                return;

            this.inOrder(node.left);
            this.nodeSorted.add(node.val);
            this.inOrder(node.right);
        }

        public boolean hasNext() {
            return current + 1 < nodeSorted.size();
        }
    }
}
