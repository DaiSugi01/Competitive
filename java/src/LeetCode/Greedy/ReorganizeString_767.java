package LeetCode.Greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReorganizeString_767 {
    /*
        "abbabbaaab"
        a: 5
        b: 5
     */
    public static void main(String[] args) {
        ReorganizeString_767 sol = new ReorganizeString_767();
        System.out.println(sol.reorganizeString("aab"));
    }

    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Character> pq = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));
        pq.addAll(map.keySet());

        StringBuffer sb = new StringBuffer();
        while (pq.size() > 1) {
            char first = pq.poll();
            char second = pq.poll();
            sb.append(first);
            sb.append(second);
            map.put(first, map.get(first) - 1);
            map.put(second, map.get(second) - 1);
            if (map.get(first) > 0) {
                pq.add(first);
            }
            if (map.get(second) > 0) {
                pq.add(second);
            }
        }

        while (!pq.isEmpty()) {
            if (map.get(pq.peek()) > 1) {
                return "";
            }
            sb.append(pq.poll());
        }

        return sb.toString();
    }
}
