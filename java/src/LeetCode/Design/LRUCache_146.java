package LeetCode.Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {
    private Map<Integer, LinkedNode> cache;
    private int capacity;
    private int size;
    private LinkedNode head;
    private LinkedNode tail;

    public LRUCache_146(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        head = new LinkedNode(-1, -1);
        head.next = tail;
        tail = head;
        tail.prev = head;
    }

    public static void main(String[] args) {
        LRUCache_146 LRU = new LRUCache_146(1);
        String[] inp = new String[]{"LRUCache", "get", "get", "put", "get", "put", "put", "put", "put", "get", "put"};
        int[][] items = new int[][]{new int[]{1}, new int[]{6}, new int[]{8}, new int[]{12, 1}, new int[]{2}, new int[]{15, 11}, new int[]{5, 2}, new int[]{1, 15}, new int[]{4, 2}, new int[]{5}, new int[]{15, 15}};

        for (int i = 0; i < inp.length; i++) {
            LRU.helper(i, inp, items);
        }
    }

    private void helper(int i, String[] inp, int[][] items) {
        if (inp[i] == "put") {
            put(items[i][0], items[i][1]);
            System.out.print("null" + ", ");
        } else if (inp[i] == "get") {
            System.out.print(String.valueOf(get(items[i][0])) + ", ");
        }
    }

    private void removeNode(LinkedNode node) {
        LinkedNode prev = node.prev;
        prev.next = node.next;
        if (prev.next != null) {
            prev.next.prev = prev;

        }
        cache.remove(node.key);
    }

    private void appendNode(LinkedNode node) {
        tail.next = node;
        node.prev = tail;
        tail = node;
        tail.next = null;
        cache.put(node.key, node);
    }

    private void removeFirst() {
        if (head.next == null) {
            tail = head;
            head.next = tail;
            tail.next = null;
            return;
        }
        cache.remove(head.next.key);
        head.next = head.next.next;
        if (head.next != null)
            head.next.prev = head;
    }

    public int get(int key) {
        LinkedNode node = cache.get(key);
        if (node == null)
            return -1;
        if (node != tail) {
            removeNode(node);
            appendNode(node);
        }
        return node.value;
    }

    public void put(int key, int value) {
        LinkedNode node = cache.get(key);

        if (node != null) {
            node.value = value;
            removeNode(node);
            appendNode(node);
        } else {
            LinkedNode newNode = new LinkedNode(key, value);
            if (size >= capacity)
                removeFirst();
            appendNode(newNode);
            size++;
        }
    }

    class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;

        public LinkedNode(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
}
