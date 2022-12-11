package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations_254 {
    List<List<Integer>> ans;

    public List<List<Integer>> getFactors(int n) {
        ans = new ArrayList<>();
        if (n < 2) return ans;
        backTracking(new ArrayList<>(), n, 2);
        return ans;
    }

    private void backTracking(List<Integer> soFar, int n, int start) {
        if (n <= 1) {
            if (soFar.size() > 1)
                ans.add(new ArrayList<>(soFar));
            return;
        }

        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                soFar.add(i);
                backTracking(soFar, n / i, i);
                soFar.remove(soFar.size() - 1);
            }
        }
    }
}
