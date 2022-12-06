package LeetCode.Graph;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberVerticesReachAllNodes_1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] nodes = new int[n];
        for (List<Integer> e : edges)
            nodes[e.get(1)]++;

        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nodes[i] == 0) vertices.add(i);
        }


        return vertices;
    }

//    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
//        int[] nodes = new int[n];
//        List<Queue<Integer>> adjList = new ArrayList<>();
//        for (int i = 0; i < n; i++)
//            adjList.add(new ArrayDeque<>());
//
//        for (List<Integer> e : edges) {
//            int u = e.get(0);
//            int v = e.get(1);
//            adjList.get(u).add(v);
//            nodes[v]++;
//        }
//
//
//        for (int i = 0; i < n; i++){
//
//        }
//
//        List<Integer> vertices = new ArrayList<>();
//        for (int i = 0; i < adjList.size(); i++) {
//            if (adjList.get(i).size() > 0) {
//                dfs(i, adjList);
//                vertices.add(i);
//            }
//        }
//
//        return vertices;
//    }
//
//    private void dfs(int from, List<Queue<Integer>> adjList) {
//        if (adjList.get(from).isEmpty()) return;
//
//        while (!adjList.get(from).isEmpty()) {
//            int dest = adjList.get(from).poll();
//            dfs(dest, adjList);
//        }
//    }
}
