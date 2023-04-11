//https://leetcode.com/problems/count-the-digits-that-divide-a-number/solutions/2984535/simple-and-concise-100-fast/?orderBy=most_votes&languageTags=java
package LeetCode.Math;

public class CountDigitsThatDivideNumber_2520 {
    public int countDigits(int num) {
        int res = 0;
        for (int x = num; x > 0; x /= 10) {
            if (num % (x % 10) == 0)
                res++;
        }

        return res;
    }
}
