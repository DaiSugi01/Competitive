package LeetCode.Mock.Amazon;

public class Q23 {
    /*
        Trie tree should have a root (node class) with an empty value

        Each node should have 3 properties
            boolean isComplete -> to see if the word is completed
            char c -> character
            Node[] children -> store each character's node
            input: hotdog
                    root
                 null null null null null ... h
                                              |
                                              a b c
     */
    class Trie {
        Node root;

        public Trie() {
            root = new Node(' ');
        }

        public void insert(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new Node(c);
                curr = curr.children[c - 'a'];
            }

            curr.isCompleted = true;
        }

        public boolean search(String word) {
            Node node = getNode(word);
            return node != null && node.isCompleted;
        }

        public boolean startsWith(String prefix) {
            return getNode(prefix) != null;
        }

        private Node getNode(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    return null;
                curr = curr.children[c - 'a'];
            }

            return curr;
        }

        class Node {
            char c;
            boolean isCompleted;

            Node[] children;

            public Node(char c) {
                this.c = c;
                this.isCompleted = false;
                this.children = new Node[26];
            }
        }
    }
}
