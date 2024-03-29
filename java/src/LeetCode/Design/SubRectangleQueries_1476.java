package LeetCode.Design;

import java.util.ArrayList;
import java.util.List;

public class SubRectangleQueries_1476 {
    class SubrectangleQueries {
        int[][] rectangle;
        List<int[]> updates;

        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
            this.updates = new ArrayList<>();
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            updates.add(new int[]{row1, col1, row2, col2, newValue});
        }

        public int getValue(int row, int col) {
            for (int i = updates.size() - 1; i >= 0; i--) {
                int[] arr = updates.get(i);
                if (row >= arr[0] && row <= arr[2] && col >= arr[1] && col <= arr[3])
                    return arr[4];
            }

            return rectangle[row][col];
        }
    }
}
