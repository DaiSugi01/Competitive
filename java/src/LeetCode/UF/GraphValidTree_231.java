package LeetCode.UF;

public class GraphValidTree_231 {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] e : edges) {
            if (!uf.union(e[0], e[1]))
                return false;
        }

        for (int i = 0; i < n - 1; i++) {
            if (!uf.connected(i, i + 1)) {
                return false;
            }
        }

        return true;
    }

    class UnionFind {
        int[] size;
        int[] ids;

        public UnionFind(int size) {
            this.size = new int[size];
            ids = new int[size];
            for (int i = 0; i < size; i++) {
                this.size[i] = 1;
                ids[i] = i;
            }
        }

        public boolean connected(int u, int v) {
            return find(u) == find(v);
        }

        private int find(int node) {
            if (ids[node] == node) return node;
            ids[node] = ids[ids[node]];
            return find(ids[node]);
        }

        public boolean union(int u, int v) {
            int uRoot = find(u);
            int vRoot = find(v);
            if (uRoot == vRoot) return false;

            if (size[uRoot] > size[vRoot]) {
                ids[vRoot] = uRoot;
                size[uRoot] += size[vRoot];
            } else {
                ids[uRoot] = vRoot;
                size[vRoot] += size[uRoot];
            }
            return true;
        }
    }
}
