package LeetCode.Mock.Amazon;

import java.util.*;

public class Q20 {
    public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> idScoreMap = new HashMap<>();
        for (int[] item : items) {
            Queue<Integer> q = idScoreMap.getOrDefault(item[0], new PriorityQueue<>((n1, n2) -> n2 - n1));
            q.add(item[1]);
            idScoreMap.put(item[0], q);
        }

        int[][] res = new int[idScoreMap.size()][2];
        int idx = 0;
        for (Map.Entry<Integer, Queue<Integer>> entry : idScoreMap.entrySet()) {
            res[idx][0] = entry.getKey();
            int sum = 0;
            int cnt = 0;
            Queue<Integer> q = entry.getValue();
            while (!q.isEmpty() && cnt < 5) {
                sum += q.poll();
                cnt++;
            }
            res[idx++][1] = sum / 5;
        }

        Arrays.sort(res, (a1, a2) -> a1[0] - a2[0]);
        return res;
    }

    private int sort(int n1, int n2) {
        return n1 - n2;
    }
}
