package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.HashMap;

public class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private HashMap<Object, Object> links;
    private int size;
    private Node tail;

    private static class Node {
        private Object data;

        private Node(Object c) {
            data = c;
        }
    }

    public ImmutableLinkedList() {

        head = null;
        links = new HashMap<>();
        tail = null;
        size = 0;

    }

    public ImmutableLinkedList(Object[] array) {
        links = new HashMap<>();
        head = new Node(array[0]);
        links.put(head, null);
        Node newHead = head;
        size++;
        for (int i = 1; i < array.length; i++) {
            Node node = new Node(array[i]);
            links.put(newHead, node);
            newHead = node;
            size++;
        }
        links.put(newHead, null);
        tail = newHead;
    }


    private ImmutableLinkedList copyInf() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        @SuppressWarnings("unchecked")
        HashMap<Object, Object> map = (HashMap<Object, Object>) links.clone();
        list.links = map;
        list.head = head;
        list.size = size();
        list.tail = tail;
        return list;
    }

    public ImmutableLinkedList add(Object e) {
        if (isEmpty()) {
            return new ImmutableLinkedList(new Object[]{e});
        }
        ImmutableLinkedList list = copyInf();
        Node el = new Node(e);
        list.links.put(tail, el);
        list.links.put(el, null);
        list.tail = el;
        list.size++;
        return list;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }
    }

    public ImmutableLinkedList add(int index, Object e) {
        checkIndex(index);
        ImmutableLinkedList list = copyInf();
        if (index == 0) {
            return list.addFirst(e);
        }
        Node node = (Node) get(index - 1, 1);
        Node el = new Node(e);
        list.links.put(el, links.get(node));
        list.links.put(node, el);
        list.size++;
        return list;
    }

    public ImmutableLinkedList addAll(Object[] c) {
        ImmutableLinkedList list = this.copyInf();
        for (int i = 0; i < c.length; i++) {
            list = list.add(c[i]);
        }
        return list;
    }

    public ImmutableLinkedList addAll(int index, Object[] c) {
        checkIndex(index);
        ImmutableLinkedList list = this.copyInf();
        for (int i = 0; i < c.length; i++) {
            list = list.add(index + i, c[i]);
        }

        return list;
    }

    private Object get(int index, int flag) {
        checkIndex(index);
        Node node = head;
        int i = 0;
        while (i != index) {
            node = (Node) links.get(node);
            i++;
        }
        if (flag == 0) {
            return node.data;
        }
        return node;
    }

    public Object get(int index) {
        return get(index, 0);
    }

    public ImmutableLinkedList remove(int index) {
        checkIndex(index);
        ImmutableLinkedList list = copyInf();
        Node node = (Node) get(index - 1, 1);
        list.links.put(node, links.get(links.get(node)));
        list.links.remove(links.get(node));
        list.size--;
        return list;
    }

    public ImmutableLinkedList set(int index, Object e) {
        checkIndex(index);
        ImmutableLinkedList list = copyInf();
        ((Node) get(index, 1)).data = e;
        return list;
    }

    public int indexOf(Object e) {
        Node currentNode = head;
        for (int i = 0; i < size() - 1; i++) {
            if (currentNode.data == e) {
                return i;
            }
            currentNode = (Node) links.get(currentNode);
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size()];
        Node currentNode = head;
        for (int i = 0; i < size(); i++) {
            arr[i] = currentNode.data;
            currentNode = (Node) links.get(currentNode);
        }
        return arr;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        return Arrays.toString(toArray());
    }


    public ImmutableLinkedList addFirst(Object e) {
        ImmutableLinkedList list = copyInf();
        Node node = new Node(e);
        list.head = node;
        list.links.put(node, head);
        list.size++;
        return list;
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Object getFirst() {
        return head.data;
    }

    public Object getLast() {
        return tail.data;
    }

    public ImmutableLinkedList removeFirst() {
        ImmutableLinkedList list = copyInf();
        list.head = (Node) links.get(head);
        list.links.remove(head);
        list.size--;
        return list;
    }

    public ImmutableLinkedList removeLast() {
        ImmutableLinkedList list = copyInf();
        Node node = (Node) get(size() - 2, 1);
        links.put(node, null);
        links.remove(links.get(node));
        list.tail = node;
        list.size--;
        return list;
    }
}

