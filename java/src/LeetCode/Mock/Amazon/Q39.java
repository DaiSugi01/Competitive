package LeetCode.Mock.Amazon;

import java.util.Stack;

public class Q39 {
    /*
        Use Stack
        loop through string:
            return false if stack is empty, and a close bracket came.

            push string to stack if it's opening bracket.
            otherwise, pop it from stack.

        return stack.isEmpty.
     */

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() && (c == ')' || c == '}' || c == ']'))
                return false;

            if (c == ')') {
                if (stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.pop() != '[')
                    return false;
            } else if (c == '}') {
                if (stack.pop() != '{')
                    return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
