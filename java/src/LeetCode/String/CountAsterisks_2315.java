//https://leetcode.com/problems/count-asterisks/description/
package LeetCode.String;

public class CountAsterisks_2315 {
    /*
        Input: s = "l|*e*et|c**o|*de|"
        Output: 2
     */
    public int countAsterisks(String s) {
        int asterisks = 0;
        int bars = 0;
        for (char c : s.toCharArray()) {
            if (bars == 1) {
                if (c == '|') bars--;
            } else {
                if (c == '*') asterisks++;
                if (c == '|') bars++;
            }
        }

        return asterisks;
    }
}
