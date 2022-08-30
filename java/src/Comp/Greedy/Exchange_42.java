package Comp.Greedy;

import java.util.HashMap;
import java.util.Map;

public class Exchange_42 {
    public static void main(String[] args) {
        int[] remindChanges = new int[]{3, 2, 1, 3, 0, 2};
        System.out.println(solve(remindChanges, 620));
    }

    private static Map<Integer, Integer> solve(int[] remindChanges, int price) {
        Map<Integer, Integer> ans = new HashMap<>();
        final int[] coins = new int[]{1, 5, 10, 50, 100, 500};
        for (int i = 5; i >= 0; i--) {
            int t = Math.min(price / coins[i], remindChanges[i]);
            price -= t * coins[i];
            ans.put(coins[i], t);
        }
        return ans;
    }

}
