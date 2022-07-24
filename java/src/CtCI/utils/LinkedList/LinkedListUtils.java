package CtCI.utils.LinkedList;

import java.util.Arrays;

public class LinkedListUtils {
    public static <T> LinkedListNode createLinkedNode(T[] items) {
        LinkedListNode<T> root = new LinkedListNode<T>(null, null, items[0]);
        if (items.length <= 1) return root;

        LinkedListNode<T> node = new LinkedListNode<T>(null, root, items[1]);
        if (items.length <= 2) return root;

        items = Arrays.copyOfRange(items, 2, items.length);
        root.next = node;
        for (T item : items) {
            node.next = new LinkedListNode<>(null, node, item);
            node = node.next;
        }
        return root;
    }

    public static void printList(LinkedListNode<Integer> current) {
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
            if (current != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }
}
