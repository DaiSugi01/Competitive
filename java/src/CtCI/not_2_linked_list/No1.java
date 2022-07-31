package CtCI.not_2_linked_list;

import CtCI.utils.LinkedList.LinkedListUtils;
import CtCI.utils.LinkedList.ListNode;

import java.util.HashSet;

public class No1 {

    public static void main(String[] args) {
        ListNode<Integer> node = LinkedListUtils.createLinkedNode(new Integer[]{1, 2, 3, 1, 4, 5, 2, 4, 6, 0});
        LinkedListUtils.printList(node);
        deleteDups(node);
        LinkedListUtils.printList(node);
    }

    private static void deleteDups(ListNode<Integer> node) {
        HashSet<Integer> set = new HashSet<>();
        ListNode<Integer> previous = null;
        while (node != null) {
            if (set.contains(node.val)) {
                previous.next = node.next;
            } else {
                set.add(node.val);
                previous = node;
            }
            node = node.next;
        }
    }
}
