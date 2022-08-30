package AlgoBook.Hashing;

public class ChainHash<K, V> {
    private int size;
    private Node<K, V>[] table;

    public ChainHash(int capacity) {
        try {
            size = capacity;
            table = new Node[capacity];
        } catch (OutOfMemoryError e) {
            size = 0;
        }
    }

    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    public V search(K key) {
        int hash = hashValue(key);
        Node<K, V> p = table[hash];
        while (p != null) {
            if (key.equals(p.getKey()))
                return p.data;
            p = p.next;
        }
        return null;
    }

    public int add(K key, V data) {
        int hash = hashValue(key);
        Node<K, V> p = table[hash];

        while (p != null) {
            if (key.equals(p.getKey()))
                return 1;
            p = p.next;
        }

        table[hash] = new Node<>(key, data, table[hash]);
        return 0;
    }

    public int remove(K key) {
        int hash = hashValue(key);
        Node<K, V> current = table[hash];
        Node<K, V> prev = null;

        while (current.next != null) {
            if (key.equals(current.getKey())) {
                if (prev == null)
                    table[hash] = current.next;
                else
                    prev.next = current.next;
                return 0;
            }
            prev = current;
            current = current.next;
        }
        return 1;
    }

    public void dump() {
        for (int i = 0; i < size; i++) {
            Node<K, V> current = table[i];
            System.out.printf("%02d: ", i);
            while (current != null) {
                System.out.printf("--> %s (%s) ", current.getKey(), current.getValue());
                current = current.next;
            }
            System.out.println();
        }
    }

    class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> next;

        Node(K key, V data, Node<K, V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return data;
        }

        public int hashCode() {
            return key.hashCode();
        }
    }
}
