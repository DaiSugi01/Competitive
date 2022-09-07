package LeetCode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_207 {
    /*
        Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
        Output: false

        [v,u]

        *Initial setup
        adj=[[1],[0]]
        inDegree=[1,1]

        topological sort using queue

        return false if one of indegree is not 0
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0)
                    q.add(v);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] > 0)
                return false;
        }

        return true;
    }
}
