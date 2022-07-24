package CtCI.not_2_linked_list;

import CtCI.utils.LinkedList.LinkedListNode;
import CtCI.utils.LinkedList.LinkedListUtils;

public class No3 {
    public static void main(String[] args) {
        LinkedListNode head = LinkedListUtils.createLinkedNode(new Integer[]{1, 2, 3, 1, 4, 5, 2, 4, 6, 0});
        LinkedListUtils.printList(head);
        deleteNode(head.next.next.next);
        LinkedListUtils.printList(head);
    }

    private static boolean deleteNode(LinkedListNode<Integer> node) {
        if (node == null || node.next == null) return false;

        LinkedListNode<Integer> next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
    }
}
