package LeetCode.Mock.Amazon;

import java.util.Stack;

public class Q40 {

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(512);
        s.push(-1024);
        s.push(-1024);
        s.push(512);
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
    }

    static class MinStack {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public MinStack() {
        }


        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }


        public void pop() {
            System.out.println(minStack.peek() == stack.peek());
            System.out.println(minStack.peek().equals(stack.peek()));
            if (minStack.peek() == stack.peek())
                minStack.pop();
            stack.pop();
        }


        public int top() {
            return stack.peek();
        }


        public int getMin() {
            return minStack.peek();
        }
    }
}
