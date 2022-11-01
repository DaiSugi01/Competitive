package LeetCode.Bit;

public class BinaryGap_858 {
    public static void main(String[] args) {
        BinaryGap_858 sol = new BinaryGap_858();
        sol.binaryGap(Integer.MAX_VALUE);
    }

    public int binaryGap(int n) {
        int last = -1, ans = 0;
        for (int i = 0; i < 32; ++i)
            if (((n >> i) & 1) > 0) {
                if (last >= 0)
                    ans = Math.max(ans, i - last);
                last = i;
            }

        return ans;
    }
}
