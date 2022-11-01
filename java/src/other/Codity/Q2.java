package other.Codity;

import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        Q2 sol = new Q2();
        System.out.println(sol.solution2(501));
        System.out.println(sol.solution2(155858));
        System.out.println(sol.solution2(54589));
        System.out.println(sol.solution2(5859));
        System.out.println(sol.solution2(5459));
        System.out.println(sol.solution2(-15958));
        System.out.println(sol.solution2(-155858));
        System.out.println(sol.solution2(-54589));
        System.out.println(sol.solution2(-5859));
        System.out.println(sol.solution2(-5459));
    }

    public int solution(int N) {
        Stack<Integer> stack = new Stack<>();
        int num = Math.abs(N);
        while (num > 0) {
            stack.push(num % 10);
            num /= 10;
        }

        int res = 0;
        if (N > 0) {
            res = extractMax(stack);
        } else {
            Stack<Integer> stack2 = new Stack<>();
            num = Math.abs(N);
            int cnt = 0;
            int digit = -1;
            while (num > 0) {
                cnt++;
                int cur = num % 10;
                if (cur == 5)
                    digit = cnt;
                stack2.push(cur);
                num /= 10;
            }

            int max2 = 0;
            while (!stack2.isEmpty()) {
                int cur = stack2.pop();
                if (stack2.size() - digit + 1 == 0) {
                    break;
                } else {
                    max2 = max2 * 10 + cur;
                }
            }

            while (!stack2.isEmpty()) {
                max2 = max2 * 10 + stack2.pop();
            }
            res = 0;
        }

        return res;
    }

    private int extractMax(Stack<Integer> stack) {
        int res = 0;
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (cur == 5) {
                if (stack.peek() == 5) {
                    res = res * 10 + cur;
                    continue;
                }
                if (stack.peek() > 5)
                    break;
            }
            res = res * 10 + cur;
        }

        while (!stack.isEmpty()) {
            res = res * 10 + stack.pop();
        }
        return res;
    }

    public int solution2(int N) {
        Stack<Integer> stack = new Stack<>();
        int num = Math.abs(N);
        while (num > 0) {
            stack.push(num % 10);
            num /= 10;
        }

        int[] numbers = new int[stack.size()];
        int p = 0;
        while (!stack.isEmpty()) {
            numbers[p++] = stack.pop();
        }

        int res = 0;
        boolean isNegative = false;
        if (N < 0) {
            N *= -1;
            isNegative = true;
            res = Integer.MAX_VALUE;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 5) {
                String numStr = String.valueOf(N);
                String newNum = numStr.substring(0, i).concat(numStr.substring(i + 1, numStr.length()));
                if (isNegative) {
                    if (Integer.valueOf(newNum) < res)
                        res = Integer.valueOf(newNum);
                } else {
                    if (Integer.valueOf(newNum) > res)
                        res = Integer.valueOf(newNum);
                }
            }
        }

        return isNegative ? res * -1 : res;
    }
}
