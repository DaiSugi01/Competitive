package LeetCode.LinkedLIst;

import CtCI.utils.LinkedList.LinkedListUtils;
import CtCI.utils.LinkedList.ListNode;

public class ReverseLinkedListII_92 {
    public static void main(String[] args) {
        ListNode<Integer> list = LinkedListUtils.createLinkedNode(new Integer[]{1, 2, 3, 4, 5});
        ReverseLinkedListII_92 sol = new ReverseLinkedListII_92();
        sol.reverseBetween(list, 2, 4);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prev = null;

        int cnt = 1;
        while (cnt < left) {
            prev = curr;
            curr = curr.next;
            cnt++;
        }
        ListNode tail = curr;
        ListNode fakeHead = prev;

        while (cnt < right) {
            prev = curr;
            curr = curr.next;
            cnt++;
        }
        ListNode first = curr;
        ListNode last = first.next;

        for (int i = 0; i <= right - left; i++) {
            ListNode temp = tail.next;
            tail.next = last;
            last = tail;
            tail = temp;
        }

        if (fakeHead == null) {
            return tail;
        } else {
            fakeHead.next = first;
        }

        return head;
    }
}
