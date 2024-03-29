package sample;

public class Trie {
    private Node root;

    public Trie() {
        root = new Node('\0');
    }

    /*
        Time : O(M) - the length of word
        Space: O(M) - the length of word
     */
    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null)
                curr.children[c - 'a'] = new Node(c);
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    /*
        Time : O(M) - the length of word
        Space: O(1)
     */
    public boolean search(String word) {
        Node node = getNode(word);
        return node != null && node.isWord;
    }

    /*
        Time : O(M) - the length of word
        Space: O(1)
     */
    public boolean startWith(String prefix) {
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
        public char c;
        public boolean isWord;
        public Node[] children;

        public Node(char c) {
            this.c = c;
            isWord = false;
            children = new Node[26];
        }
    }
}
