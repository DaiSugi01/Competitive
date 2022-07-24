package CtCI.utils.LinkedList;

public class LinkedListNode<T> {
    public LinkedListNode next;
    public LinkedListNode previous;
    public T data;

    public LinkedListNode(LinkedListNode next, LinkedListNode previous, T data) {
        this.next = next;
        this.previous = previous;
        this.data = data;
    }
}