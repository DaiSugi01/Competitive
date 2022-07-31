package CtCI.not_2_linked_list;

import CtCI.utils.LinkedList.LinkedListUtils;
import CtCI.utils.LinkedList.ListNode;

public class No3 {
    public static void main(String[] args) {
        ListNode head = LinkedListUtils.createLinkedNode(new Integer[]{1, 2, 3, 1, 4, 5, 2, 4, 6, 0});
        LinkedListUtils.printList(head);
        deleteNode(head.next.next.next);
        LinkedListUtils.printList(head);
    }

    private static boolean deleteNode(ListNode<Integer> node) {
        if (node == null || node.next == null) return false;

        ListNode<Integer> next = node.next;
        node.val = next.val;
        node.next = next.next;
        return true;
    }
}
