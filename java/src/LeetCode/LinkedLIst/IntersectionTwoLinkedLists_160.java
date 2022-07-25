package LeetCode.LinkedLIst;

import CtCI.utils.LinkedList.LinkedListNode;
import CtCI.utils.LinkedList.LinkedListUtils;

import java.util.HashMap;

public class IntersectionTwoLinkedLists_160 {
    public static void main(String[] args) {
        LinkedListNode<Integer> nodeA = LinkedListUtils.createLinkedNode(new Integer[]{1, 2});
        LinkedListNode<Integer> nodeB = LinkedListUtils.createLinkedNode(new Integer[]{1, 2, 3, 4});
        LinkedListNode<Integer> nodeC = LinkedListUtils.createLinkedNode(new Integer[]{1, 2, 3, 4});
        nodeA.next.next = nodeC;
        nodeB.next.next.next.next = nodeC;
    }

    public static LinkedListNode<Integer> getIntersectionNode1(LinkedListNode headA, LinkedListNode headB) {
        HashMap<LinkedListNode, Boolean> map = new HashMap<>();
        while (headA != null) {
            map.put(headA, true);
            headA = headA.next;
        }

        while (headB != null) {
            if (map.containsKey(headB)) return headB;
            headB = headB.next;
        }

        return null;
    }

    public static LinkedListNode<Integer> getIntersectionNode2(LinkedListNode headA, LinkedListNode headB) {
        LinkedListNode p1 = headA;
        LinkedListNode p2 = headB;

        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }

}
