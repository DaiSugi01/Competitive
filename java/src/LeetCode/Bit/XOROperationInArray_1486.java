package LeetCode.Bit;

public class XOROperationInArray_1486 {
    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            res ^= start + (2 * i);
        }

        return res;
    }
}
