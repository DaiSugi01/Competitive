package LeetCode.String;

public class MaximumNumberBalloons_1189 {
    public static void main(String[] args) {
        MaximumNumberBalloons_1189 sol = new MaximumNumberBalloons_1189();
        System.out.println(sol.maxNumberOfBalloons("nlaebolko"));
    }

    public int maxNumberOfBalloons(String text) {
        int[] bucket = new int[26];
        for (char c : text.toCharArray())
            bucket[c - 'a'] += 1;

        int res = Integer.MAX_VALUE;
        for (char c : "balloon".toCharArray()) {
            if (c == 'l' || c == 'o')
                res = Math.min(bucket[c - 'a'] / 2, res);
            else
                res = Math.min(bucket[c - 'a'], res);
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
