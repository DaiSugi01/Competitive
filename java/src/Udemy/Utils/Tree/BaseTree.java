package Udemy.Utils.Tree;

public class BaseTree {
    protected Node root;

    public BaseTree() {
        this.root = null;
    }

    public void printPostorder() {
        _printPostorder(this.root);
    }

    public void _printPostorder(Node node) {
        if (node == null) return;

        _printPreorder(node.left);
        _printPreorder(node.right);
        System.out.println(node.value);
    }

    public void printInorder() {
        _printInorder(root);
    }

    public void _printInorder(Node node) {
        if (node == null) return;

        System.out.println(node.value);
        _printPreorder(node.left);
        _printPreorder(node.right);
    }

    public void printPreorder() {
        _printPreorder(root);
    }

    private void _printPreorder(Node node) {
        if (node == null) return;

        _printPreorder(node.left);
        System.out.println(node.value);
        _printPreorder(node.right);
    }
}
