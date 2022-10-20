package LeetCode.Array;

public class ValidMountainArray_941 {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        if (arr[0] >= arr[1]) return false;
        if (arr[arr.length - 1] >= arr[arr.length - 2]) return false;

        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] >= arr[i + 1] && arr[j] >= arr[j - 1]) return false;
            if (arr[i] < arr[i + 1]) {
                i++;
            }

            if (arr[j] < arr[j - 1]) {
                j--;
            }
        }

        return i == j;
    }
}

