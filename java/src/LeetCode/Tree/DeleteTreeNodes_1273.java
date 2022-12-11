package LeetCode.Tree;

import java.util.ArrayList;
import java.util.List;

public class DeleteTreeNodes_1273 {
    int remindNodes;

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        remindNodes = nodes;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < nodes; i++) {
            if (parent[i] >= 0)
                adjList.get(parent[i]).add(i);
        }

        dfs(0, adjList, value);

        return remindNodes;
    }

    private int[] dfs(int currentNode, List<List<Integer>> adjList, int[] value) {
        int[] res = new int[]{0, 0};
        for (int node : adjList.get(currentNode)) {
            int[] r = dfs(node, adjList, value);
            res[0] += r[0];
            res[1] += r[1];
        }

        if (res[0] + value[currentNode] == 0) {
            remindNodes -= (res[1] + 1);
            return new int[]{0, 0};
        }
        return new int[]{res[0] + value[currentNode], res[1] + 1};
    }
}
