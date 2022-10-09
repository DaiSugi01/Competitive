package LeetCode.Design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146_practice {
    class LRUCache {
        Node head;
        Node tail;
        Map<Integer, Node> cache;
        int capacity;

        public LRUCache(int capacity) {
            cache = new HashMap<>();
            head = new Node(-1, -1);
            tail = head;
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null)
                return -1;
            if (node != tail) {
                removeNode(node);
                addNode(node);
            }
            return node.val;
        }

        void addNode(Node node) {
            tail.next = node;
            node.prev = tail;
            tail = node;
            tail.next = null;
            cache.put(node.key, node);
        }

        void removeNode(Node node) {
            Node prev = node.prev;
            prev.next = node.next;
            if (prev.next != null) {
                prev.next.prev = prev;

            }
            cache.remove(node.key);
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

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node != null) {
                node.val = value;
                removeNode(node);
                addNode(node);
            } else {
                Node newNode = new Node(key, value);
                if (cache.size() >= capacity)
                    removeFirst();
                addNode(newNode);
            }
        }
    }

    class Node {
        int val;
        int key;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
