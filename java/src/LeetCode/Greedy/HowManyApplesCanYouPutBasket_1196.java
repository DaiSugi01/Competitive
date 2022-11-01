package LeetCode.Greedy;

import java.util.Arrays;

public class HowManyApplesCanYouPutBasket_1196 {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int currentWeight = 0;
        int apples = 0;
        for (int a : weight) {
            currentWeight += a;
            if (currentWeight <= 5000) {
                apples++;
            } else {
                return apples;
            }
        }

        return apples;
    }
}
