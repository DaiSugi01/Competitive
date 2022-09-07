package LeetCode.Greedy;

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        ContainerWithMostWater_11 sol = new ContainerWithMostWater_11();
//        System.out.println(sol.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
//        System.out.println(sol.maxArea(new int[]{4, 3, 2, 1, 4}));
//        System.out.println(sol.maxArea(new int[]{1, 1}));
        System.out.println(sol.maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
    }

    public int maxArea(int[] height) {
        int maxWater = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int width = r - l;
            maxWater = Math.max(maxWater, Math.min(height[l], height[r]) * width);
            if (height[l] < height[r])
                l++;
            else
                r--;
        }

        return maxWater;
    }
}
