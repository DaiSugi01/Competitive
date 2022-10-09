package LeetCode.Mock.Amazon;

public class Q11 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int sq1 = rec1[0] > rec1[2] ? rec1[0] - rec1[2] : rec1[2] - rec1[0];
        int sq2 = rec2[0] > rec2[2] ? rec2[0] - rec2[2] : rec2[2] - rec2[0];

        int[] smaller = sq1 > sq2 ? rec2 : rec1;
        int[] larger = sq1 > sq2 ? rec1 : rec2;

        if (smaller[0] >= larger[2] || smaller[2] <= larger[0] || smaller[1] >= larger[3] || smaller[3] <= larger[1])
            return false;


        return true;
    }
}
