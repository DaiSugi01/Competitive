//https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
package LeetCode.String;

public class FinalValueOfVariableAfterPerformingOperations_2011 {
    public static void main(String[] args) {

    }

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String o : operations) {
            if (o.equals("++X") || o.equals("X++")) {
                x++;
            } else if (o.equals("--X") || o.equals("X--")) {
                x--;
            }
        }

        return x;
    }
}
