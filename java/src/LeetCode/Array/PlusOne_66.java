package LeetCode.Array;

public class PlusOne_66 {
    public static void main(String[] args) {
    }

    /*
        Input: digits = [9,9,9]
        Output: [1,0,0,0]

        reverse loop
        len = digits[i].length;
        for loop
        sum = digits[i] + 1;
        if the sum >= 10, assign 0 to digits[i]
        otherwise, digit[i] = sum, and return it.

        res = new int[len + 1]
        res[0] = 1;

     */
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] newDigits = new int[len + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
