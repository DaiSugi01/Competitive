package LeetCode.UF;

import java.util.HashSet;
import java.util.Set;

public class NumberOperationsMakeNetworkConnected_1319 {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        Set<Integer> set = new HashSet<>();
        UnionFind uf = new UnionFind(n);
        for (int[] c : connections) {
            set.add(c[0]);
            set.add(c[1]);
            uf.union(c[0], c[1]);
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (uf.union(i, i + 1)) {
                res++;
            }
        }

        return res;
    }

    class UnionFind {
        private int[] size;
        private int[] ids;

        public UnionFind(int size) {
            this.size = new int[size];
            ids = new int[size];
            for (int i = 0; i < size; i++) {
                this.size[i] = 1;
                ids[i] = i;
            }
        }

        public int find(int node) {
            if (node == ids[node]) return node;
            ids[node] = ids[ids[node]];
            return find(ids[node]);
        }

        public boolean union(int u, int v) {
            int uRoot = find(u);
            int vRoot = find(v);
            if (uRoot == vRoot)
                return false;

            if (size[u] > size[v]) {
                ids[vRoot] = u;
                size[uRoot] += size[vRoot];
            } else {
                ids[uRoot] = v;
                size[vRoot] += size[uRoot];
            }

            return true;
        }
    }
}
