package LeetCode.Array;

public class Difference_2535 {
    public int differenceOfSum(int[] nums) {
        int eleSum = 0, digSum = 0;
        for (int num : nums) {
            eleSum += num;
            digSum += getDigitSum(num);
        }

        return Math.abs(eleSum - digSum);
    }

    private int getDigitSum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num = num / 10;
        }

        return res;
    }
}
