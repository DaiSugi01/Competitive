// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/
package LeetCode.Bit;

public class MinimumBitFlipsToConvertNumber_2220 {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int count = 0;

        while (xor > 0) {
            count++;
            xor &= xor - 1;
        }

        return count;
    }
}
