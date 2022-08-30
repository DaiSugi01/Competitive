package LeetCode.Greedy;

public class DIStringMatch_942 {
    public static void main(String[] args) {
        System.out.println(diStringMatch("III"));
    }

    /*
        Input: s = "IDID"
        Output: [0,4,1,3,2]

        i = 0
        d = the length of the given string

        will assign i, if 1st is I, and increment i by 1
        otherwise, assign d, and decrement d by 1;
     */
    public static int[] diStringMatch(String s) {
        int low = 0;
        int high = s.length();
        int[] res = new int[s.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I')
                res[i] = low++;
            else
                res[i] = high--;
        }

        res[s.length()] = low;
        return res;
    }
}
