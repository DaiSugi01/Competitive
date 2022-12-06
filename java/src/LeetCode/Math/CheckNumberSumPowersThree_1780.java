package LeetCode.Math;

import java.util.HashMap;
import java.util.Map;

public class CheckNumberSumPowersThree_1780 {
    public static void main(String[] args) {
        CheckNumberSumPowersThree_1780 sol = new CheckNumberSumPowersThree_1780();
        System.out.println(sol.checkPowersOfThree(27));
    }

    public boolean checkPowersOfThree(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; (int) Math.pow(3, i) <= n; i++) {
            map.put(i, (int) Math.pow(3, i));
            count++;
        }

        count--;
        int current = n;
        for (int i = count; i >= 0; i--) {
            if (current >= map.get(i))
                current -= map.get(i);
        }

        return current == 0;
    }

}
