package LeetCode.LinkedLIst;

import CtCI.utils.LinkedList.LinkedListUtils;
import CtCI.utils.LinkedList.ListNode;

import java.util.HashMap;

public class IntersectionTwoLinkedLists_160 {
    public static void main(String[] args) {
        ListNode<Integer> nodeA = LinkedListUtils.createLinkedNode(new Integer[]{1, 2});
        ListNode<Integer> nodeB = LinkedListUtils.createLinkedNode(new Integer[]{1, 2, 3, 4});
        ListNode<Integer> nodeC = LinkedListUtils.createLinkedNode(new Integer[]{1, 2, 3, 4});
        nodeA.next.next = nodeC;
        nodeB.next.next.next.next = nodeC;
    }

    public static ListNode<Integer> getIntersectionNode1(ListNode headA, ListNode headB) {
        HashMap<ListNode, Boolean> map = new HashMap<>();
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

    public static ListNode<Integer> getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }

}
