package LeetCode.Tree.Utuils;

public class TreeNode<T> {

    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return " --> " + String.valueOf(val);
    }
}
