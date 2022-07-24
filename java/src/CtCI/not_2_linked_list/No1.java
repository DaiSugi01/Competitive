package CtCI.not_2_linked_list;

import CtCI.utils.LinkedList.LinkedListNode;
import CtCI.utils.LinkedList.LinkedListUtils;

import java.util.HashSet;

public class No1 {

    public static void main(String[] args) {
        LinkedListNode<Integer> node = LinkedListUtils.createLinkedNode(new Integer[]{1, 2, 3, 1, 4, 5, 2, 4, 6, 0});
        LinkedListUtils.printList(node);
        deleteDups(node);
        LinkedListUtils.printList(node);
    }

    private static void deleteDups(LinkedListNode<Integer> node) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode<Integer> previous = null;
        while (node != null) {
            if (set.contains(node.data)) {
                previous.next = node.next;
            } else {
                set.add(node.data);
                previous = node;
            }
            node = node.next;
        }
    }
}
