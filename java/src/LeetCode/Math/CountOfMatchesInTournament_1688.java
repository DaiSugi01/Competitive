//https://leetcode.com/problems/count-of-matches-in-tournament/description/
package LeetCode.Math;

public class CountOfMatchesInTournament_1688 {
    public int numberOfMatches(int n) {
        if (n == 1) return 0;
        boolean isEven = n % 2 == 0;
        int numOfMatches = isEven ? n / 2 : (n - 1) / 2;
        return numOfMatches + numberOfMatches(isEven ? n / 2 : (n - 1) / 2 + 1);
    }
}
