package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsSystem_1268 {
    public static void main(String[] args) {
        SearchSuggestionsSystem_1268 sol = new SearchSuggestionsSystem_1268();
        System.out.println(sol.suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>(new ArrayList<>());
        Trie trie = new Trie();
        for (String s : products)
            trie.insert(s);

        StringBuffer sb = new StringBuffer();
        for (char c : searchWord.toCharArray()) {
            sb.append(c);
            res.add(trie.getWordsStartingWith(sb.toString()));
        }

        return res;
    }

    class Trie {
        Node root;
        List<String> wordList;

        public Trie() {
            root = new Node('\0');
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

        public List<String> getWordsStartingWith(String prefix) {
            Node curr = root;
            wordList = new ArrayList<>();
            for (char c : prefix.toCharArray()) {
                if (curr.children[c - 'a'] == null)
                    return wordList;
                curr = curr.children[c - 'a'];
            }
            dfsWithPrefix(curr, prefix);

            return wordList;
        }

        private void dfsWithPrefix(Trie.Node curr, String word) {
            if (wordList.size() == 3)
                return;
            if (curr.isCompleted)
                wordList.add(word);

            for (char c = 'a'; c <= 'z'; c++) {
                if (curr.children[c - 'a'] != null) {
                    dfsWithPrefix(curr.children[c - 'a'], word + c);
                }
            }
        }

        class Node {
            public char c;
            public boolean isCompleted;
            public Node[] children;

            public Node(char c) {
                this.c = c;
                isCompleted = false;
                children = new Node[26];
            }
        }
    }
}
