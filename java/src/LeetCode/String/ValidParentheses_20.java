package LeetCode.String;

import java.util.*;

public class ValidParentheses_20 {
    public static void main(String[] args) {
        System.out.println(isValid("(("));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("())"));
    }

    /*
        - stack ----[         ]
        mapping open and close bracket
        {
            ')': '('
        }
        loop through array
            if map does not contains the char
                -> push to stack
            else 
                -> return false if stack is empty 
                -> return false if (top element of the stack is not the pair bracket)

        return stack.isEmpty();
     */
    public static boolean isValid(String s) {
        HashMap<Character, Character> bracketMap = new HashMap<>() {
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!bracketMap.containsKey(c)) {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) return false;

            if (stack.pop() != bracketMap.get(c)) return false;
        }

        return stack.isEmpty();
    }
}
