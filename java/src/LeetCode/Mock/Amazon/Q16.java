/*
Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.

Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
 */
package LeetCode.Mock.Amazon;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Q16 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Integer, Queue<Node>> orgValMap = new HashMap<>();
        Map<Integer, Queue<Node>> newValMap = new HashMap<>();
        Node current = head.next;
        Node newHead = new Node(head.val);
        Node newNode = newHead;

        while (current != null) {
            // create {3:Queue[null, 3, null]}
            Queue<Node> q = orgValMap.getOrDefault(current.val, new ArrayDeque<>());
            q.add(current.random == null ? new Node(Integer.MIN_VALUE) : current.random);
            orgValMap.put(current.val, q);

            // create {3:Queue[null, 3, null]}
            q = newValMap.getOrDefault(newNode.val, new ArrayDeque<>());
            q.add(newNode);
            newValMap.put(newNode.val, q);

            newNode.next = new Node(current.val);
            newNode = newNode.next;
            current = current.next;
        }
        Queue<Node> q = newValMap.getOrDefault(newNode.val, new ArrayDeque<>());
        q.add(newNode);
        newValMap.put(newNode.val, q);

        /*
            [[3,null],[3,0],[3,null]]

            orgValMap = {
                3:[null, 0, null],
            }

            newValMap = {
                3:[0, 1, 2],
            }

            first -> null
            second ->
         */
        current = newHead;
        while (current != null) {
            Queue<Node> orgRandomPtrs = orgValMap.get(current.val);
            if (orgRandomPtrs != null && !orgRandomPtrs.isEmpty()) {
                Node nextRandom = orgRandomPtrs.poll();
                if (nextRandom.val == Integer.MIN_VALUE)
                    current.random = null;
                else
                    current.random = newValMap.get(nextRandom.val).poll();
            } else {
                current.random = null;
            }
            current = current.next;
        }

        return newHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
