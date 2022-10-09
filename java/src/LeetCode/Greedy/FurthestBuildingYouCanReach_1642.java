package LeetCode.Greedy;

public class FurthestBuildingYouCanReach_1642 {
    public static void main(String[] args) {
        FurthestBuildingYouCanReach_1642 sol = new FurthestBuildingYouCanReach_1642();
        System.out.println(sol.furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
    }

    /*
        Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
        Output: 4
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int builds = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i - 1] - heights[i] > bricks && ladders > 0) {
                ladders--;
                builds++;
            }
        }

        return builds;
    }
}
