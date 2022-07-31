package CtCI.not_2_linked_list;

import CtCI.utils.LinkedList.LinkedListUtils;
import CtCI.utils.LinkedList.ListNode;

public class No2 {
    public static void main(String[] args) {
        ListNode<Integer> head = LinkedListUtils.createLinkedNode(new Integer[]{1, 2, 3, 1, 4, 5, 2, 4, 6, 0});
        LinkedListUtils.printList(head);
        System.out.println(nthToLast(head, 3));
    }

    private static int nthToLast(ListNode<Integer> head, int n) {
        ListNode<Integer> p1 = head;
        ListNode<Integer> p2 = head;

        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2.val;
    }
}
