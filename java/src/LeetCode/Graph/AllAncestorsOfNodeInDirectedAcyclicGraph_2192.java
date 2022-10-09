package LeetCode.Graph;

import java.util.*;

public class AllAncestorsOfNodeInDirectedAcyclicGraph_2192 {
    /*
        [[0,7],[7,6],[0,3],[6,3],[5,4],[1,5],[2,7],[3,5],[3,1],[0,5],[7,5],[2,1],[1,4],[6,1]]

        {
            0: []
            1: []
            2: []
            3: [0,1]
            4: [0,2]
            5: [3]
            6: [3,4]
            7: [2,3]
        }
     */
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Set<Integer>[] adjacencyList = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new HashSet<>();
        }
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adjacencyList[v].add(u);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adjacencyList[i].size() == 0) {
                res.add(new ArrayList<>());
            } else {
                Set<Integer> set = new HashSet<>();
                dfs(adjacencyList[i], adjacencyList, set);
                List<Integer> list = new ArrayList<>(set);
                Collections.sort(list);
                res.add(list);
            }
        }

        return res;
    }

    private void dfs(Set<Integer> nodes, Set<Integer>[] adjacencyList, Set<Integer> set) {
        for (int num : nodes) {
            if (!set.contains(num)) {
                set.add(num);
                dfs(adjacencyList[num], adjacencyList, set);
            }
        }
    }
}
