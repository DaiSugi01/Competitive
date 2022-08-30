package LeetCode.DP;

public class DivisorGame_1025 {
    public static void main(String[] args) {
        System.out.println(divisorGame(5));
    }

    public static boolean divisorGame(int N) {

        if (N == 1) return false;
        if (N == 2) return true;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0)
                return !(divisorGame(N - i));
        }
        return false;
    }
}
