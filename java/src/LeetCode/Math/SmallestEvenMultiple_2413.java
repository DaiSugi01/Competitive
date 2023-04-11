//https://leetcode.com/problems/smallest-even-multiple/description/
package LeetCode.Math;

public class SmallestEvenMultiple_2413 {
    public static void main(String[] args) {
    }

    public int smallestEvenMultiple(int n) {
        while (n % 2 != 0) {
            n *= 2;
        }

        return n;
    }
}
