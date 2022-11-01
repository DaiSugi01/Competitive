package other.Codity;

public class Q1 {
    public static void main(String[] args) {
        Q1 sol = new Q1();
        sol.solution(4);
    }

    public void solution(int N) {
        if (N <= 0) return;
        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                System.out.println("L".repeat(N));
            } else {
                System.out.println("L");
            }
        }
    }
}
