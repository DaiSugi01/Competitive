package sample;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    public static void main(String[] args) {


    }

    private static void topologicalSort(int[][] arr, int N, int M) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());
        int[] inDegree = new int[N + 1];

        for (int[] a : arr) {
            int u = a[0];
            int v = a[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        // Initial setup
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < N; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0)
                    q.add(v);
            }
        }
    }
}
