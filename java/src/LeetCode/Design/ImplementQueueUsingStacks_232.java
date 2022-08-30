package LeetCode.Design;

import java.util.ArrayList;

public class ImplementQueueUsingStacks_232 {

    class MyQueue {
        ArrayList<Integer> stack;
        ArrayList<Integer> rest;

        public MyQueue() {
            stack = new ArrayList<>();
            rest = new ArrayList<>();
        }

        public void push(int x) {
            stack.add(x);
        }

        /*
            // if the rest is not empty, pop from rest
            // otherwise, move items to rest array and pop an item from rest
        */
        public int pop() {
            if (rest.isEmpty()) {
                while (!stack.isEmpty()) {
                    rest.add(stack.remove(stack.size() - 1));
                }
            }

            return rest.remove(rest.size() - 1);
        }

        public int peek() {
            return rest.isEmpty() ? stack.get(0) : rest.get(rest.size() - 1);
        }

        public boolean empty() {
            return rest.isEmpty() && stack.isEmpty();
        }
    }
}
