package LeetCode.heap;

import java.util.*;

class Pair {
    final String word;
    int freq;

    public Pair(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }
}

public class TopKFrequentWords_692 {
    public static void main(String[] args) {

    }

    /*
        PriorityQueue which contains word, freq
        sort above based on the freq.
        return the response
     */
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.freq == o2.freq) {
                    return o1.word.compareTo(o2.word);
                } else {
                    return o2.freq - o1.freq;
                }
            }
        });

        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        List<String> freqList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            freqList.add(pq.poll().word);
        }

        return freqList;
    }

    /*
        Create hash map to get freq {"a": 2, "b": 1}
        sort words arr based on the freq in map
     */
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        List<String> res = new ArrayList<>(map.keySet());
        Collections.sort(res, (w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
        return res.subList(0, k);
    }
}
