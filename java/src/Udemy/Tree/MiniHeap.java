package Udemy.Tree;

import java.util.ArrayList;
import java.util.Arrays;

public class MiniHeap {

    private final int ROOT_INDEX = 1;
    public ArrayList<Integer> heap;
    public int size;

    MiniHeap() {
        heap = new ArrayList<>(Arrays.asList(Integer.MIN_VALUE));
        size = 0;
    }

    public int parentIndex(int index) {
        return index / 2;
    }

    public int leftChildIndex(int index) {
        return 2 * index;
    }

    public int rightChildIndex(int index) {
        return (2 * index) + 1;
    }

    public void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    /*
        Time Complexity : O(log n)
        Space Complexity: O(1)
     */
    public void heapifyUp(int index) {
        while (this.parentIndex(index) > 0) {
            if (heap.get(index) < heap.get(parentIndex(index))) {
                swap(index, parentIndex(index));
            }
            index = parentIndex(index);
        }
    }

    /*
        Time Complexity : O(log n)
        Space Complexity: O(1)
     */
    public void push(int value) {
        heap.add(value);
        size++;
        heapifyUp(size);
    }

    /*
        Time Complexity : O(1)
        Space Complexity: O(1)
     */
    public int minChildIndex(int index) {
        if (rightChildIndex(index) > size) {
            return leftChildIndex(index);
        }

        return heap.get(leftChildIndex(index)) < heap.get(rightChildIndex(index)) ?
                leftChildIndex(index) : rightChildIndex(index);
    }

    /*
        Time Complexity : O(log n)
        Space Complexity: O(1)
     */
    public void heapifyDown(int index) {
        while (leftChildIndex(index) <= size) {
            int minChildIndex = minChildIndex(index);
            if (heap.get(index) > heap.get(minChildIndex)) {
                swap(index, minChildIndex);
            }
            index = minChildIndex;
        }
    }

    /*
        Time Complexity : O(log n)
        Space Complexity: O(1)
     */
    public Integer pop() {
        if (heap.size() == 1) {
            return null;
        }

        int root = heap.get(ROOT_INDEX);
        int data = heap.remove(size);
        if (heap.size() == 1)
            return root;
        heap.set(ROOT_INDEX, data);
        size--;
        heapifyDown(ROOT_INDEX);

        return root;

    }
}
