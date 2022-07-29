package LeetCode.LinkedLIst;

import CtCI.utils.LinkedList.LinkedListNode;

public class LinkedListCycle_141 {
    public static void main(String[] args) {
    }

    public boolean hasCycle(LinkedListNode head) {
        if (head == null) {
            return false;
        }

        LinkedListNode slow = head;
        LinkedListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
