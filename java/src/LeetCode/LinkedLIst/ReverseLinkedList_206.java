package LeetCode.LinkedLIst;

import CtCI.utils.LinkedList.ListNode;

public class ReverseLinkedList_206 {
    /*
        Input: head = [1,2,3,4,5]
        prev = null
        loop through given linked list while the node is not null
            store currentNode.next to temp variable
            currentNode.next = prev;
            prev = tempNpde;
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }

        return prev;
    }
}
