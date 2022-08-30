package LeetCode.LinkedLIst;

import CtCI.utils.LinkedList.LinkedListUtils;
import CtCI.utils.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList_234 {
    public static void main(String[] args) {
        ListNode<Integer> node = LinkedListUtils.createLinkedNode(new Integer[]{1, 2, 2, 1});
        System.out.println(isPalindrome2(node));
    }

    public static boolean isPalindrome2(ListNode<Integer> head) {
        if (head == null) return false;
        ListNode<Integer> firstHalf = getFirstHalf(head);
        ListNode<Integer> reversedHalf = reverseList(firstHalf.next);

        ListNode<Integer> p1 = head;
        ListNode<Integer> p2 = reversedHalf;
        while (p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

    private static ListNode<Integer> reverseList(ListNode<Integer> node) {
        ListNode<Integer> prev = null;
        ListNode<Integer> current = node;

        while (current != null) {
            ListNode<Integer> nextTempNode = current.next;
            current.next = prev;
            prev = current;
            current = nextTempNode;
        }

        return prev;
    }

    private static ListNode<Integer> getFirstHalf(ListNode<Integer> node) {
        ListNode<Integer> fast = node;
        ListNode<Integer> slow = node;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public boolean isPalindrome1(ListNode<Integer> head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
