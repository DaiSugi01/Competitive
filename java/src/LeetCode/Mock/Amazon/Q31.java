package LeetCode.Mock.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q31 {

    public static void main(String[] args) {
        Q31 sol = new Q31();
        System.out.println(sol.wordBreak("aaaaaaa", new ArrayList<>(Arrays.asList("aaaa", "aaa"))));
        System.out.println(sol.wordBreak("aaaaaaa", new ArrayList<>(Arrays.asList("aaaa", "aa"))));
        System.out.println(sol.wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen"))));
        System.out.println(sol.wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
        System.out.println(sol.wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }

        return trie.search(s);
    }


    class Trie {
        Node root;

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

        boolean search(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                Node node = curr.children[word.charAt(i) - 'a'];

                if (node == null)
                    return false;
                if (node.isCompleted) {
                    if (i == word.length() - 1) {
                        curr = node;
                        break;
                    }
                    curr = root;
                } else
                    curr = node;
            }
            return curr.isCompleted;
        }
    }

    class Node {
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
