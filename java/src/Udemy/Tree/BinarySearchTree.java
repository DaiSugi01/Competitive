package Udemy.Tree;

import Udemy.Utils.Tree.BaseTree;
import Udemy.Utils.Tree.Node;

import java.util.Objects;

public class BinarySearchTree extends BaseTree {

    BinarySearchTree() {
        super();
    }

    public void insert(int value) {
        if (Objects.isNull(this.root)) {
            this.root = new Node(value);
            return;
        }

        _insert(this.root, value);
    }

    private Node _insert(Node node, int value) {
        if (Objects.isNull(node))
            return new Node(value);

        if (value < node.value) {
            node.left = _insert(node.left, value);
        } else {
            node.right = _insert(node.right, value);
        }

        return node;
    }

    public boolean search(int value) {
        return _search(this.root, value);
    }

    private boolean _search(Node node, int value) {
        if (Objects.isNull(node))
            return false;

        if (value == node.value) {
            return true;
        } else if (value < node.value) {
            return _search(node.left, value);
        } else {
            return _search(node.right, value);
        }
    }

    public void remove(int value) {
        _remove(this.root, value);
    }

    private Node _remove(Node node, int value) {
        if (Objects.isNull(node))
            return node;

        if (value < node.value) {
            node.left = _remove(node.left, value);
        } else if (value > node.value) {
            node.right = _remove(node.right, value);
        } else {
            if (Objects.isNull(node.left)) {
                return node.right;
            } else if (Objects.isNull(node.right)) {
                return node.left;
            }

            Node temp = minValue(node.right);
            node.value = temp.value;
            node.right = _remove(temp.right, temp.value);
        }
        return node;
    }

    private Node minValue(Node node) {
        Node current = node;
        while (!Objects.isNull(current.left)) {
            current = current.left;
        }
        return current;
    }
}
