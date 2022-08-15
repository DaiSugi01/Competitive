package Udemy.Tree;

public class MainTree {
    public static void main(String[] args) {
        bst();
    }

    private static void bst() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.remove(19);
        bst.insert(14);
        bst.remove(19);
        bst.remove(9);
        bst.insert(0);
        bst.insert(3);
        bst.insert(4);
        bst.insert(0);
        bst.remove(9);
        bst.printPreorder();
//        int[] nums = new int[]{5, 10, 9, 51, 2, 4, 1};
//        for (int num : nums) {
//            bst.insert(num);
//        }
//        bst.printPreorder();
    }

    private static void miniHeap() {
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
