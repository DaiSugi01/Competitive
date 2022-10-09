package LeetCode.String;

public class OutputContestMatches_544 {
    public static void main(String[] args) {
        OutputContestMatches_544 sol = new OutputContestMatches_544();
        sol.findContestMatch(8);
    }

    public String findContestMatch(int n) {
        String[] m = new String[n / 2];
        for (int i = 0; i < n; i++) {
            m[i] = String.valueOf(i + 1);
        }

        while (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                m[i] = "(" + m[i] + "," + m[n - 1 - i] + ")";
            }
            n /= 2;
        }

        return m[0];
    }
}
