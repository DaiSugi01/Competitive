//https://leetcode.com/problems/decode-xored-array/description/
package LeetCode.Bit;

public class Decode_XORed_Array_1720 {
    public static void main(String[] args) {
        decode(new int[]{1, 2, 3}, 1);
    }

    public static int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] res = new int[n + 1];
        res[0] = first;
        for (int i = 0; i < n; i++) {
            res[i + 1] = res[i] ^ encoded[i];
        }

        return res;
    }
}
