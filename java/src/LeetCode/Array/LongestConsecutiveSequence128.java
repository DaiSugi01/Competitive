package LeetCode.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {
        LongestConsecutiveSequence128 sol = new LongestConsecutiveSequence128();
        System.out.println(sol.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    public int longestConsecutive(int[] nums) {
        UnionFind uf = new UnionFind();
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                if (set.contains(nums[i] - 1)) {
                    uf.union(nums[i] - 1, nums[i]);
                }
                if (set.contains(nums[i] + 1)) {
                    uf.union(nums[i], nums[i] + 1);
                }

                if (!set.contains(nums[i] + 1) && !set.contains(nums[i] - 1)) {
                    uf.union(nums[i]);
                }

                max = Math.max(max, uf.getSize(nums[i]));
            }
        }

        return max;
    }

    class UnionFind {
        Map<Integer, Integer> size;
        Map<Integer, Integer> ids;

        public UnionFind() {
            this.size = new HashMap<>();
            this.ids = new HashMap<>();
        }

        void union(int node) {
            size.put(node, 1);
            ids.put(node, node);
        }

        void union(int smaller, int larger) {
            int sRoot = 0;
            int lRoot = 0;
            if (!ids.containsKey(smaller)) {
                ids.put(smaller, smaller);
                size.put(smaller, 1);
                sRoot = smaller;
            } else {
                sRoot = find(smaller);
            }
            if (!ids.containsKey(larger)) {
                ids.put(larger, larger);
                size.put(larger, 1);
                lRoot = larger;
            } else {
                lRoot = find(larger);
            }

            if (sRoot == lRoot) return;
            size.put(lRoot, size.get(lRoot) + size.get(sRoot));
            ids.put(sRoot, lRoot);
        }

        int find(int node) {
            if (ids.get(node) == node) return node;
            return find(ids.get(node));
        }

        int getSize(int node) {
            return this.size.get(find(node));
        }
    }
}
