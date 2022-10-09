package LeetCode.Mock.Amazon;

import java.util.Stack;

public class Q43 {
    abstract class Node {
        public abstract int evaluate();
        // define your fields here
    }

    class NumNode extends Node {
        int num;

        public NumNode(int num) {
            this.num = num;
        }

        @Override
        public int evaluate() {
            return num;
        }
    }

    class OpNode extends Node {
        String operator;
        Node left;
        Node right;

        public OpNode(String op, Node left, Node right) {
            this.operator = op;
            this.left = left;
            this.right = right;
        }

        @Override
        public int evaluate() {
            if (operator.equals("+"))
                return left.evaluate() + right.evaluate();
            else if (operator.equals("-"))
                return left.evaluate() - right.evaluate();
            else if (operator.equals("*"))
                return left.evaluate() * right.evaluate();
            else if (operator.equals("/"))
                return left.evaluate() / right.evaluate();
            else
                return 0;
        }
    }

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            Stack<Node> stack = new Stack<>();
            for (String numOrOperator : postfix) {
                if (Character.isDigit(numOrOperator.charAt(0))) {
                    stack.push(new NumNode(Integer.valueOf(numOrOperator)));
                } else {
                    Node right = stack.pop();
                    Node left = stack.pop();
                    stack.push(new OpNode(numOrOperator, left, right));
                }
            }
            return stack.peek();
        }
    }
}
