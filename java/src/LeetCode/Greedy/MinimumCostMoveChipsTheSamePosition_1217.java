package LeetCode.Greedy;

public class MinimumCostMoveChipsTheSamePosition_1217 {
    /*
        Input: position = [2,2,2,4,3]
        Output: 1
     */
    public int minCostToMoveChips(int[] position) {
        int evenCount = 0;
        for (int p : position) {
            if (p % 2 == 0)
                evenCount++;
        }

        return Math.min(evenCount, position.length - evenCount);
    }
}
