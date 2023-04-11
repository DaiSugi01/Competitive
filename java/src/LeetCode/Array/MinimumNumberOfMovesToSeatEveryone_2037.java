//https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/
package LeetCode.Array;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone_2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int numOfMoves = 0;
        for (int i = 0; i < seats.length; i++) {
            numOfMoves += Math.abs(seats[i] - students[i]);
        }

        return numOfMoves;
    }
}
