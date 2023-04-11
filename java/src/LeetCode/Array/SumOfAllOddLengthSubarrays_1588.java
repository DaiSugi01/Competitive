package LeetCode.Array;

public class SumOfAllOddLengthSubarrays_1588 {
    public static void main(String[] args) {
        sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3, 6});
    }

    /*
        Input: arr = [1,4,2,5,3,6]
        Output: 58
        end
        1
        start
        1,4
        1,4,2
        1,4,2,5
        1,4,2,5,3
        1,4,2,5,3,6

        end
        1
        1,4

        start
        4
        4,2
        4,2,5
        4,2,5,3
        4,2,5,3,6
     */
    public static int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length, res = 0;

        for (int i = 0; i < n; ++i) {
            int start = n - i;
            int end = i + 1;
            int total = start * end;
            int odd = total / 2;
            if (total % 2 == 1)
                odd++;
            res += odd * arr[i];
        }

        return res;
    }
}
