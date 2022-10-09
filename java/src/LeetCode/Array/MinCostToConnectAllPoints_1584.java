package LeetCode.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinCostToConnectAllPoints_1584 {
    public static void main(String[] args) {
        MinCostToConnectAllPoints_1584 sol = new MinCostToConnectAllPoints_1584();
        System.out.println(sol.minCostConnectPoints(new int[][]{
                new int[]{0, 0},
                new int[]{2, 2},
                new int[]{3, 10},
                new int[]{5, 2},
                new int[]{7, 0},
//                new int[]{3, 12},
//                new int[]{-2, 5},
//                new int[]{-4, 1},
        }));
    }

    public int minCostConnectPoints(int[][] points) {
        List<Pair> allCosts = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                allCosts.add(new Pair(Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]), i, j));
            }
        }
        Collections.sort(allCosts, (p1, p2) -> Integer.compare(p1.weight, p2.weight));

        int cost = 0;
        UnionFind uf = new UnionFind(points.length);
        for (Pair p : allCosts) {
            if (uf.union(p.from, p.to)) {
                cost += p.weight;
            }
        }

        return cost;
    }

    class UnionFind {
        private int[] size;
        private int[] ids;

        public UnionFind(int size) {
            this.size = new int[size];
            this.ids = new int[size];
            for (int i = 0; i < size; i++) {
                ids[i] = i;
                this.size[i] = 1;
            }
        }

        public boolean union(int u, int v) {
            int uRoot = find(u);
            int vRoot = find(v);
            if (uRoot == vRoot) return false;

            if (size[u] > size[v]) {
                ids[vRoot] = u;
                size[uRoot] += size[vRoot];
            } else {
                ids[uRoot] = v;
                size[vRoot] += size[uRoot];
            }
            return true;
        }

        public int find(int node) {
            if (ids[node] == node) return node;
            ids[node] = ids[ids[node]];
            return find(ids[node]);
        }
    }

    class Pair {
        int weight;
        int from;
        int to;

        public Pair(int w, int f, int t) {
            weight = w;
            from = f;
            to = t;
        }
    }
}
