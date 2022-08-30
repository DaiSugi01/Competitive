package LeetCode.Math;

public class PowerOfThree_326 {
    public static void main(String[] args) {
        isPowerOfThree(5);
    }

    public static boolean isPowerOfThree(int n) {
        if (n < 1) return false;

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
