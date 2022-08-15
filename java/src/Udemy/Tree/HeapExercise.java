package Udemy.Tree;

import java.util.*;

class Pair {
    String word;
    int freq;

    public Pair(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }
}

public class HeapExercise {
    public static void main(String[] args) {
        String[] words = new String[]{"python", "c", "java", "go", "python", "c", "go", "python"};
        System.out.println(kth(words, 2));
    }

    public static List<String> kth(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.freq == o2.freq) {
                    return o1.word.compareTo(o2.word);
                } else {
                    return o2.freq - o1.freq;
                }
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            heap.add(new Pair(entry.getKey(), entry.getValue()));
        }

        ArrayList<String> res = new ArrayList<>(map.keySet());
        return res.subList(0, k);
    }
}
