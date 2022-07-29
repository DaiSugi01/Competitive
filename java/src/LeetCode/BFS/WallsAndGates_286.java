package LeetCode.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates_286 {
    private final int EMPTY = Integer.MAX_VALUE;
    private final int GATE = 0;
    private final int[][] Distances = new int[][]{
            new int[]{1, 0},
            new int[]{1, -1},
            new int[]{0, 1},
            new int[]{0, -1},
    };

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m ==0 ) return;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
            }
        }

    }

    public static void main(String[] args) {
    }
}
