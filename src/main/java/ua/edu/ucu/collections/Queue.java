package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList linked;

    public Queue() {
        linked = new ImmutableLinkedList();
    }

    public Queue(Object[] arr) {
        linked = new ImmutableLinkedList(arr);
    }

    public Object peek() {
        return linked.getFirst();
    }

    public Object dequeue() {
        Object last = peek();
        linked = linked.removeFirst();
        return last;
    }

    public void enqueue(Object e) {
        linked = linked.add(e);
    }

    @Override
    public String toString() {
        return linked.toString();
    }
}