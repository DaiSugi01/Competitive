package LeetCode.Bit;

public class ReverseBits_190 {
    public static void main(String[] args) {
        System.out.println(reverseBits(5));
    }

    public static int reverseBits(int n) {
        int answer = 0; // initializing answer
        for (int i = 0; i < 32; i++) { // 32 bit integers
            answer <<= 1; // shifts answer over 1 to open a space
            System.out.println((n >> i));
            answer |= ((n >> i) & 1); // inserts bits from n
        }
        return answer;
    }
}
