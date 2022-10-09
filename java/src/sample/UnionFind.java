package sample;

public class UnionFind {
    /*
        Algorithm                Init     Union       Find
        Quick Find                N        N           1
        Quick Union               N        N           N
        Weight + QU               N       lgN         lgN
        Path Compression + QU     N       lgN         lgN
        W +PC + QU                N       lgN*         lgN
     */
    /*
        - union() -> O(N)
            worst case is still O(N) but it's faster than Quick Find in practical.
            since we just need to find its root node. don't need to traverse all node.
        - find() -> O(1)
     */
    class QuickFind {
        int[] ids;

        public QuickFind(int size) {
            ids = new int[size];
            for (int i = 0; i < size; i++) {
                ids[i] = i;
            }
        }

        public boolean find(int u, int v) {
            return ids[u] == ids[v];
        }

        public void union(int u, int v) {
            int uId = ids[u];
            int vId = ids[v];
            for (int i = 0; i < ids.length; i++) {
                if (ids[i] == uId) ids[i] = vId;
            }
        }
    }

    /*
        - union() -> O(N)
            worst case is still O(N) but it's faster than Quick Find in practical.
            since we just need to find its root node. don't need to traverse all node.
        - find() -> O(N)
     */
    class QuickUnion {
        int[] ids;

        public QuickUnion(int size) {
            ids = new int[size];
            for (int i = 0; i < size; i++) {
                ids[i] = i;
            }
        }

        public void union(int u, int v) {
            int uRoot = root(u);
            int vRoot = root(v);
            ids[uRoot] = ids[vRoot];
        }

        private int root(int node) {
            if (ids[node] == node) return node;
            return root(ids[node]);
        }

        public boolean find(int u, int v) {
            return root(u) == root(v);
        }
    }

    class PathCompWeightedQuickUnion {
        int[] ids;
        int[] size;

        public PathCompWeightedQuickUnion(int size) {
            this.size = new int[size];
            for (int i = 0; i < size; i++) {
                ids[i] = 1;
            }

            ids = new int[size];
            for (int i = 0; i < size; i++) {
                ids[i] = i;
            }
        }

        public void union(int u, int v) {
            int uRoot = root(u);
            int vRoot = root(v);
            if (size[uRoot] > size[vRoot]) {
                ids[vRoot] = uRoot;
                size[uRoot] += size[vRoot];
            } else {
                ids[uRoot] = vRoot;
                size[vRoot] += size[uRoot];
            }
        }

        private int root(int node) {
            if (ids[node] == node) return node;
            ids[node] = ids[ids[node]];
            return root(ids[node]);
        }

        public boolean find(int u, int v) {
            return root(u) == root(v);
        }
    }
}
