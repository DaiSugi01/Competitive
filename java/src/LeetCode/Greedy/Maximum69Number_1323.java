package LeetCode.Greedy;

public class Maximum69Number_1323 {
    /*
        9699
        10000 - 9699 = 301
        3 digits

        9699 + 300
        return num + 10^2 * 3
     */
    public int maximum69Number(int num) {
        int digits = (int) (Math.log10((double) num));
        int place = (int) (Math.pow(10, digits));

        while (place > 0) {
            if ((num / place) % 10 == 6) {
                return num + (3 * place);
            }
            place /= 10;
        }
        return num;
    }

    public int maximum69Number2(int num) {
        int place = 1;
        int maxPlace = Integer.MIN_VALUE;
        int n = num;

        while (n > 0) {
            int d = n % 10;
            if (d == 6) {
                maxPlace = place;
            }
            place *= 10;
            n /= 10;
        }

        return (maxPlace == Integer.MIN_VALUE) ? num : num + (3 * maxPlace);
    }
}
