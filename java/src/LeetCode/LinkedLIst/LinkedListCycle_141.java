package LeetCode.LinkedLIst;

import CtCI.utils.LinkedList.ListNode;

public class LinkedListCycle_141 {
    public static void main(String[] args) {
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
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
