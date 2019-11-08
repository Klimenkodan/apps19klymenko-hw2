package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList linked;

    public Stack() {
        linked = new ImmutableLinkedList();
    }

    public Stack(Object[] arr) {

        linked = new ImmutableLinkedList(arr);
    }

    public Object peek() {
        return linked.getLast();
    }

    public Object pop() {
        Object last = peek();
        linked = linked.removeLast();
        return last;
    }

    public void push(Object e) {
        linked = linked.addFirst(e);
    }

    @Override
    public String toString() {
        return linked.toString();
    }
}
