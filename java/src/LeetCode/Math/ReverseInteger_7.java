package LeetCode.Math;

public class ReverseInteger_7 {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }

        int reversed = 0;
        while (x > 0) {
            int remind = x % 10;
            if (reversed > Integer.MAX_VALUE / 10 ||
                    (reversed == Integer.MAX_VALUE / 10 && remind > 8))
                return 0;
            if (isNegative && reversed < Integer.MIN_VALUE / 10 ||
                    (reversed == Integer.MIN_VALUE / 10 && remind > 9))
                return 0;
            reversed = reversed * 10 + remind;
            x /= 10;
        }

        if (isNegative)
            reversed *= -1;

        return reversed;
    }
}
