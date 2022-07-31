package CtCI.utils.LinkedList;

import java.util.Arrays;

public class LinkedListUtils {
    public static <T> ListNode createLinkedNode(T[] items) {
        ListNode<T> root = new ListNode<T>(null, null, items[0]);
        if (items.length <= 1) return root;

        ListNode<T> node = new ListNode<T>(null, root, items[1]);
        if (items.length <= 2) return root;

        items = Arrays.copyOfRange(items, 2, items.length);
        root.next = node;
        for (T item : items) {
            node.next = new ListNode<>(null, node, item);
            node = node.next;
        }
        return root;
    }

    public static void printList(ListNode<Integer> current) {
        while (current != null) {
            System.out.print(current.val);
            current = current.next;
            if (current != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }
}
