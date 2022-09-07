package LeetCode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adj.add(new ArrayList<>());
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int v = 0; v < numCourses; v++) {
            if (inDegree[v] == 0)
                q.add(v);
        }

        int i = 0;
        int[] ans = new int[numCourses];
        while (!q.isEmpty()) {
            int u = q.poll();
            ans[i++] = u;
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0)
                    q.add(v);
            }
        }

        for (int n : inDegree) {
            if (n > 0)
                return new int[]{};
        }

        return ans;
    }
}
