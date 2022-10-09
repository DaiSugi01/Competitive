package LeetCode.Mock.Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Q13 {
    public static void main(String[] args) {
        Q13 sol = new Q13();
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = new String[]{"a"};
        System.out.println(sol.mostCommonWord(paragraph, banned));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replace(",", " ");
        paragraph = paragraph.replace(".", " ");

        String[] words = Stream.of(paragraph.split(" ")).map(s1 -> {
            if (s1.isBlank())
                return "";
            if (Character.isAlphabetic(s1.charAt(s1.length() - 1)))
                return s1;
            return s1.substring(0, s1.length() - 1);
        }).filter(s1 -> !s1.isBlank()).toArray(String[]::new);

        Map<String, Integer> map = new HashMap<>();
        for (String w : words)
            map.put(w.toLowerCase(), map.getOrDefault(w.toLowerCase(), 0) + 1);

        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> map.get(s2.toLowerCase()) - map.get(s1.toLowerCase()));
        for (String w : words)
            pq.add(w);

        while (!pq.isEmpty()) {
            String s = pq.poll().toLowerCase();
            if (!Arrays.asList(banned).contains(s))
                return s;
        }

        return "";
    }
}
