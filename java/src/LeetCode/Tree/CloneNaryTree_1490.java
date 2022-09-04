package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class CloneNaryTree_1490 {
    public Node cloneTree(Node root) {
        if (root == null) return null;

        Node newRoot = new Node(root.val);
        for (Node n : root.children) {
            newRoot.children.add(cloneTree(n));
        }

        return newRoot;
    }

}
