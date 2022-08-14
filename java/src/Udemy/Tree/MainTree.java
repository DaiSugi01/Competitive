package Udemy.Tree;

public class MainTree {
    public static void main(String[] args) {
        int[] heapArr = new int[]{5, 6, 2, 9, 13, 11};
        MiniHeap heap = new MiniHeap();
        for (int i : heapArr) {
            heap.push(i);
        }
        System.out.println(heap.heap);
        heap.pop();
        System.out.println(heap.heap);
    }
}
