package LeetCode.LinkedLIst;

import CtCI.utils.LinkedList.ListNode;

public class MergeTwoSortedLists_21 {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode<Integer> list1, ListNode<Integer> list2) {
        ListNode<Integer> preHead = new ListNode<>(null, null, -1);
        ListNode<Integer> prev = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }

        prev.next = list1 == null ? list2 : list1;
        return preHead.next;
    }
}
