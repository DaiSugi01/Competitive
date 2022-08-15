package LeetCode.Design;

/*
    hashTable = [Bucket1, Bucket2, ..., BucketN] size: 2096
    Bucket should be LinkedList<KeyValueStore<Integer, Integer>>

    - To store the item
    hashKey = bucket hashTable size
    LinkedList<> <Key, Value> -> <Key, Value>

    get:
 */

import Udemy.Utils.Tree.Node;

import java.util.Objects;


public class DesignHashMap2_706 {

    private MyBucket[] bucketArr;
    private int keyRange;

    public DesignHashMap2_706() {
        keyRange = 769;
        bucketArr = new MyBucket[keyRange];
        for (int i = 0; i < keyRange; ++i)
            bucketArr[i] = new MyBucket();
    }

    private int _hash(int key) {
        return key % keyRange;
    }

    public void add(int key) {
        bucketArr[_hash(key)].insertIntoBST(key);
    }

    public void remove(int key) {
        bucketArr[_hash(key)].removeNodeFromBst(key);
    }

    public boolean contains(int key) {
        return bucketArr[_hash(key)].search(key);
    }
}

class MyBucket {
    BSTree tree;

    MyBucket() {
        this.tree = new BSTree();
    }

    void insertIntoBST(int key) {
        this.tree.root = this.tree.insert(this.tree.root, key);
    }

    boolean search(int key) {
        return this.tree.search(key);
    }

    void removeNodeFromBst(int key) {
        this.tree.root = this.tree.remove(this.tree.root, key);
    }
}

class BSTree {
    public Node root;

    public BSTree() {
        this.root = null;
    }

    Boolean search(int key) {
        return Objects.isNull(_search(this.root, key));
    }

    private Node _search(Node node, int key) {
        if (Objects.isNull(node) || key == node.value) {
            return node;
        }

        return key < node.value ? _search(node.left, key) : _search(node.right, key);
    }

    public Node insert(Node node, int value) {
        if (Objects.isNull(node))
            return new Node(value);

        if (value == node.value) {
            return node;
        } else if (value < node.value) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        return node;
    }

    public Node remove(Node node, int key) {
        if (node == null)
            return null;

        // delete from the right subtree
        if (key > node.value)
            node.right = remove(node.right, key);
            // delete from the left subtree
        else if (key < node.value)
            node.left = remove(node.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (node.left == null && node.right == null)
                node = null;
                // the node is not a leaf and has a right child
            else if (node.right != null) {
                node.value = successor(node);
                node.right = remove(node.right, node.value);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                node.value = predecessor(node);
                node.left = remove(node.left, node.value);
            }
        }
        return node;
    }

    public int successor(Node root) {
        root = root.right;
        while (root.left != null)
            root = root.left;
        return root.value;
    }

    public int predecessor(Node root) {
        root = root.left;
        while (root.right != null)
            root = root.right;
        return root.value;
    }
}
