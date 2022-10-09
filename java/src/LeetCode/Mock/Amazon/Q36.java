package LeetCode.Mock.Amazon;

import java.util.ArrayList;
import java.util.List;

public class Q36 {
    public static void main(String[] args) {
        Q36 sol = new Q36();
        sol.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse");
    }

    /*
        Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
        Insert products into trie tree
                    m
                    o
                  b  u    n
                  i  s   e i
                  l  e   y t
                  e  p   p o
                     a   o r
                     d   t
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products)
            trie.insert(product);

        List<List<String>> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (char c : searchWord.toCharArray()) {
            sb.append(c);
            res.add(trie.getWordWithPrefix(sb.toString()));
        }

        return res;
    }

    private class Trie {
        Node root;
        List<String> wordList;

        public Trie() {
            root = new Node(' ');
        }

        void insert(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    curr.children[c - 'a'] = new Node(c);
                curr = curr.children[c - 'a'];
            }
            curr.isCompleted = true;
        }

        List<String> getWordWithPrefix(String prefix) {
            wordList = new ArrayList<>();
            Node curr = root;
            for (char c : prefix.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    return wordList;
                curr = curr.children[c - 'a'];
            }

            dfsSearch(curr, prefix);
            return wordList;
        }

        void dfsSearch(Node node, String word) {
            if (wordList.size() == 3)
                return;
            if (node.isCompleted)
                wordList.add(word);

            for (char c = 'a'; c <= 'z'; c++) {
                if (wordList.size() == 3)
                    return;
                if (node.children[c - 'a'] != null)
                    dfsSearch(node.children[c - 'a'], word + c);
            }
        }
    }

    private class Node {
        char c;
        boolean isCompleted;
        Node[] children;

        public Node(char c) {
            this.c = c;
            isCompleted = false;
            children = new Node[26];
        }
    }
}
