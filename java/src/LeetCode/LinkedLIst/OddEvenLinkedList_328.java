package LeetCode.LinkedLIst;

public class OddEvenLinkedList_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode tail = head;
        int numOfNodes = 1;
        while (tail.next != null) {
            tail = tail.next;
            numOfNodes++;
        }

        if (numOfNodes <= 2) return head;
        
        int i = 0;
        ListNode current = head;
        ListNode prev = head;
        while (i < numOfNodes) {
            if (i % 2 != 0) {
                prev.next = current.next;
                current.next = null;
                tail.next = current;
                tail = tail.next;
            } else {
                prev = current;
            }
            i++;
            current = prev.next;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
