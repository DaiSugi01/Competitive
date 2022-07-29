package LeetCode.Design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    hashTable = [Bucket1, Bucket2, ..., BucketN] size: 2096
    Bucket should be LinkedList<KeyValueStore<Integer, Integer>>

    - To store the item
    hashKey = bucket hashTable size
    LinkedList<> <Key, Value> -> <Key, Value>

    get:
 */

class KeyValue<U, V> {
    U key;
    V value;

    KeyValue(U key, V value) {
        this.key = key;
        this.value = value;
    }
}

class Bucket<U, V> {

    List<KeyValue<Integer, Integer>> bucket;

    public Bucket() {
        this.bucket = new LinkedList<KeyValue<Integer, Integer>>();
    }

    public int get(int key) {
        for (KeyValue<Integer, Integer> pair : this.bucket) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        for (KeyValue<Integer, Integer> pair : this.bucket) {
            if (pair.key.equals(key)) {
                pair.value = value;
                return;
            }
        }

        this.bucket.add(new KeyValue<>(key, value));
    }

    public void remove(int key) {
        for (KeyValue<Integer, Integer> pair : this.bucket) {
            if (pair.key.equals(key)) {
                this.bucket.remove(pair);
                return;
            }
        }
    }
}

public class DesignHashMap_706 {
    final int KEY_SPACE = 2096;
    List<Bucket> hashTable;

    public DesignHashMap_706() {
        this.hashTable = new ArrayList<Bucket>();
        for (int i = 0; i < KEY_SPACE; i++) {
            this.hashTable.add(new Bucket());
        }
    }

    public void put(int key, int value) {
        int hashKey = key % KEY_SPACE;
        this.hashTable.get(hashKey).put(key, value);
    }

    public int get(int key) {
        int hashKey = key % KEY_SPACE;
        return this.hashTable.get(hashKey).get(key);
    }

    public void remove(int key) {
        int hashKey = key % KEY_SPACE;
        this.hashTable.get(hashKey).remove(key);
    }
}
