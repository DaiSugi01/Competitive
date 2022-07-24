package CtCI.not_2_linked_list;

import CtCI.utils.LinkedList.LinkedListNode;
import CtCI.utils.LinkedList.LinkedListUtils;

public class No2 {
    public static void main(String[] args) {
        LinkedListNode<Integer> head = LinkedListUtils.createLinkedNode(new Integer[]{1, 2, 3, 1, 4, 5, 2, 4, 6, 0});
        LinkedListUtils.printList(head);
        System.out.println(nthToLast(head, 3));
    }

    private static int nthToLast(LinkedListNode<Integer> head, int n) {
        LinkedListNode<Integer> p1 = head;
        LinkedListNode<Integer> p2 = head;

        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2.data;
    }
}
