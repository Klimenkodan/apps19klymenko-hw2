package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] arr;

    ImmutableArrayList() {

        arr = new Object[]{};
    }

    private ImmutableArrayList(ImmutableArrayList array, int flag) {
        arr = Arrays.copyOf(array.arr, array.size() + flag);
    }

    public int size() {
        return arr.length;
    }

    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    public int indexOf(Object e) {
        for (int i = 0; i < size(); i++) {
            if (arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(arr, size());
    }

    public ImmutableArrayList add(Object e) {
        return add(size(), e);
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
    }


    public ImmutableArrayList add(int index, Object e) {
        checkIndex(index);
        ImmutableArrayList list = new ImmutableArrayList(this, 1);
        if (index == size) {
            list.add(e);
            return list;
        } 
        for (int i = 0; i < index; i++) {
            list.arr[i] = arr[i];
        }
        list.arr[index] = e;

        for (int i = index; i < arr.length; i++) {
            list.arr[i + 1] = arr[i];
        }
        return list;
    }

    public ImmutableArrayList addAll(Object[] c) {
        return addAll(size(), c);
    }

    public ImmutableArrayList addAll(int index, Object[] c) {
        checkIndex(index);

        ImmutableArrayList array = new ImmutableArrayList();
        for (int i = 0; i < index; i++) {
            array = array.add(arr[i]);
        }

        for (int i = 0; i < c.length; i++) {
            array = array.add(c[i]);
        }

        for (int i = index; i < size(); i++) {
            array = array.add(arr[i]);
        }
        return array;
    }

    public Object get(int index) {
        checkIndex(index);
        return this.arr[index];
    }

    public ImmutableArrayList remove(int index) {
        checkIndex(index);
        ImmutableArrayList lst = new ImmutableArrayList();
        for (int i = 0; i < size(); i++) {
            if (i != index) {
                lst = lst.add(arr[i]);
            }
        }
        return lst;
    }

    public ImmutableArrayList set(int index, Object e) {
        checkIndex(index);
        ImmutableArrayList lst = new ImmutableArrayList(this, 0);
        lst.arr[index] = e;
        return lst;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        return Arrays.toString(toArray());
    }
}


