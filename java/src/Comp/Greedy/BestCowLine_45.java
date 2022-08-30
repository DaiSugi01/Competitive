package Comp.Greedy;

public class BestCowLine_45 {
    public static void main(String[] args) {
        System.out.println(solve(6, "ACDBCB"));
    }

    /*
        use l=0, r=s.length()-1
        ans=A
        ACDBCB
          l

        loop through string r - l times
            if a char at left + i < a char at right - i -> left is smaller
            else if a char at left + i > a char at right  -> right is smaller

        if a letter at i is less than a letter at j   -> pick character at i and increment i by 1
        otherwise, pick a char at j and decrement j by 1
     */
    private static String solve(int n, String s) {
        int left = 0;
        int right = s.length() - 1;

        StringBuffer sb = new StringBuffer();
        while (left <= right) {
            boolean isLeftSmall = false;
            for (int i = 0; i < right - left; i++) {
                if (s.charAt(left + i) < s.charAt(right - i)) {
                    isLeftSmall = true;
                    break;
                } else if (s.charAt(left + i) > s.charAt(right - i)) {
                    isLeftSmall = false;
                    break;
                }
            }
            if (isLeftSmall) {
                sb.append(s.charAt(left++));
            } else {
                sb.append(s.charAt(right--));
            }
        }
        return sb.toString();
    }
}
