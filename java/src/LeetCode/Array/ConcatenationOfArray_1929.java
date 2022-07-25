package LeetCode.Array;

public class ConcatenationOfArray_1929 {
    public static void main(String[] args) {
        System.out.println(getConcatenation(new int[]{1, 2, 3}));
    }

    public static int[] getConcatenation(int[] nums) {
        int[] newArr = new int[nums.length * 2];
        System.arraycopy(nums, 0, newArr, 0, nums.length);
        System.arraycopy(nums, 0, newArr, nums.length, nums.length);
        return newArr;
    }
}
