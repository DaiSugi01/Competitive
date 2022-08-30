package LeetCode.Greedy;

import java.util.Stack;

public class SplitStringBalancedStrings_1221 {

    // RLRRLLRLRL
    public int balancedStringSplit2(String s) {
        int res = 0;
        int rCount = 0;
        int lCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                rCount++;
            } else {
                lCount++;
            }

            res += rCount == lCount ? 1 : 0;
        }
        return res;
    }

    public int balancedStringSplit(String s) {
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() == c) {
                stack.push(c);
            } else {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res++;
            }
        }
        return res;
    }

}
