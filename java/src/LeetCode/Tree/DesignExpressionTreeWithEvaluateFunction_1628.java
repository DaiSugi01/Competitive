package LeetCode.Tree;

import java.util.Stack;

public class DesignExpressionTreeWithEvaluateFunction_1628 {
    abstract class Node {
        public abstract int evaluate();
        // define your fields here
    }

    class NumNode extends Node {
        int val;

        public NumNode(int val) {
            this.val = val;
        }

        @Override
        public int evaluate() {
            return val;
        }
    }

    class OpNode extends Node {
        private char op;
        private Node left;
        private Node right;

        public OpNode(char op, Node left, Node right) {
            this.op = op;
            this.left = left;
            this.right = right;
        }

        @Override
        public int evaluate() {
            switch (this.op) {
                case '+':
                    return this.left.evaluate() + this.right.evaluate();
                case '-':
                    return this.left.evaluate() - this.right.evaluate();
                case '*':
                    return this.left.evaluate() * this.right.evaluate();
                case '/':
                    return this.left.evaluate() / this.right.evaluate();
                default:
                    return 0;
            }
        }
    }

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            Stack<Node> stack = new Stack<>();
            for (String s : postfix) {
                if (Character.isDigit(s.charAt(0))) {
                    stack.push(new NumNode(Integer.parseInt(s)));
                } else {
                    Node right = stack.pop();
                    Node left = stack.pop();
                    stack.push(new OpNode(s.charAt(0), left, right));
                }
            }
            return stack.peek();
        }
    }
}
