package LeetCode.Array;

import java.util.*;

public class HighFive_1086 {
    public int[][] highFive(int[][] items) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < items.length; i++) {
            int id = items[i][0];
            if (!set.contains(id)) {
                pq.add(id);
                set.add(id);
            }
        }

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            int key = items[i][0];
            if (!map.containsKey(key))
                map.put(key, new PriorityQueue<>(Comparator.reverseOrder()));
            map.get(key).add(items[i][1]);
        }

        int[][] ans = new int[pq.size()][2];
        int p = 0;
        while (!pq.isEmpty()) {
            int id = pq.poll();
            int count = 0;
            int sum = 0;
            while (count < 5) {
                if (map.get(id).isEmpty()) break;
                sum += map.get(id).poll();
                count++;
            }
            ans[p++] = new int[]{id, sum / count};
        }

        return ans;
    }
}
