package LeetCode.Graph;

import java.util.ArrayList;
import java.util.List;

public class NumberConnectedComponentsUndirectedGraph_323 {
    boolean[] visited;

    public int countComponents(int n, int[][] edges) {
        visited = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adjList);
                components++;
            }
        }

        return components;
    }

    private void dfs(int node, List<List<Integer>> adjList) {
        if (visited[node]) return;
        visited[node] = true;

        for (int u : adjList.get(node)) {
            dfs(u, adjList);
        }
    }
}
