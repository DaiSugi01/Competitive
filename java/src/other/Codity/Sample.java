package other.Codity;

import java.util.*;

public class Sample {
    int res;

    public static void main(String[] args) {
        Sample sol = new Sample();
        System.out.println(sol.solution2(
//                new int[]{0, 4, 4, 2, 7, 6, 3},
//                new int[]{3, 5, 1, 3, 4, 3, 4}
//                new int[]{0, 3, 4, 2, 6, 3},
//                new int[]{3, 1, 3, 3, 3, 5}
                new int[]{0, 4, 2, 2, 4},
                new int[]{1, 3, 1, 3, 5}
//                new int[]{0},
//                new int[]{1}
        ));
    }

    public int solution(int[] A, int[] B) {
        if (A.length != B.length) return 0;
        res = 0;
        int size = A.length;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int u = A[i];
            int v = B[i];
            List<Integer> list = adjList.getOrDefault(u, new ArrayList<>());
            list.add(v);
            adjList.put(u, list);

            List<Integer> list2 = adjList.getOrDefault(v, new ArrayList<>());
            list2.add(u);
            adjList.put(v, list2);
        }

        for (int i = 0; i <= size; i++) {
            dfs(i, new HashSet<>(), adjList);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(3);
        pq.add(2);
        System.out.println(pq.toString());
        return res + A.length;
    }

    private void dfs(int u, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        if (visited.contains(u)) return;

        visited.add(u);
        if (visited.size() > 3 && (visited.size() + 1) % 2 != 0) res++;
        for (int num : adjList.get(u)) {
            dfs(num, visited, adjList);
        }
        visited.remove(u);
    }

    public int solution2(int[] A, int[] B) {
        UnionFind uf = new UnionFind(A.length + 1);
        for (int i = 0; i < A.length; i++)
            uf.union(A[i], B[i]);

        for (int i = 0; i <= A.length; i++) {
            for (int j = i + 1; j <= A.length; j++) {
                int links = uf.find(i, j, 0);
                if (links > 2 && links % 2 != 0) {
                    res++;
                }
            }
        }

        return res + A.length;
    }

    class UnionFind {
        int[] ids;
        int[] size;

        public UnionFind(int size) {
            this.size = new int[size];
            ids = new int[size];
            for (int i = 0; i < size; i++) {
                this.size[i] = 1;
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

        public int find(int u, int v, int numOfLinks) {
            if (u == v) return numOfLinks;

            if (size[u] == size[v]) {
                if (ids[u] == u) {
                    return find(u, ids[v], numOfLinks + 1);
                } else if (ids[v] == v) {
                    return find(ids[u], v, numOfLinks + 1);
                }
                return find(ids[u], ids[v], numOfLinks + 2);
            } else if (size[u] > size[v]) {
                return find(u, ids[v], numOfLinks + 1);
            } else {
                return find(ids[u], v, numOfLinks + 1);
            }
        }
    }
}
