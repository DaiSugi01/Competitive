package CtCI.utils.LinkedList;

public class ListNode<T> {
    public ListNode next;
    public ListNode previous;
    public T val;

    public ListNode(ListNode next, ListNode previous, T data) {
        this.next = next;
        this.previous = previous;
        this.val = data;
    }
}