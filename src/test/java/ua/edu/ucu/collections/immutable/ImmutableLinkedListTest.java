package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    ImmutableLinkedList list = new ImmutableLinkedList();
    @Test
    public void testAdd() {
        ImmutableLinkedList list1 = list.add(1);
        assertArrayEquals(list1.toArray(), new Object[] {1});
        ImmutableLinkedList list2 = list1.add(2);
        assertArrayEquals(list2.toArray(), new Object[] {1, 2});
        list2 = list2.add(4).add(5).add(1, 3);
        assertArrayEquals(list2.toArray(), new Object[] {1, 3, 2, 4, 5});
        assertArrayEquals(list2.addFirst(3).toArray(), new Object[] {3, 1, 3, 2, 4, 5});
        assertArrayEquals(list2.addLast(3).toArray(), new Object[] {1, 3, 2, 4, 5, 3});

    }

    @Test
    public void testAddAll() {
        ImmutableLinkedList list1 = list.addAll(new Object[] {1, 2, 3, 4, 5});
        assertArrayEquals(list1.toArray(), new Object[] {1, 2, 3, 4, 5});
        list1 = list1.addAll(2, new Object[] {6, 7, 8});
        assertArrayEquals(list1.toArray(), new Object[] {1, 2, 6, 7, 8, 3, 4, 5});
    }

    @Test
    public void testClear() {
        ImmutableLinkedList list1 = list.add(1);
        ImmutableLinkedList list2 = list1.clear();
        assertArrayEquals(list2.toArray(), new Object[] {});
    }


    @Test
    public void testSize() {
        list = list.add(1);
        assertEquals(list.size(), 1);
        list = list.remove(0);
        assertEquals(list.size(), 0);
    }
    @Test
    public void testIndexOf() {
        list = list.add(1).add(2).add(3);
        assertEquals(list.indexOf(2), 1);
        assertEquals(list.indexOf(5), -1);

    }
    @Test
    public void testGet() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list = list.addAll(new Object[] {1, 2, 3, 4});
        assertEquals(list.get(2), 3);
        assertEquals(list.getLast(), 4);
        assertEquals(list.getFirst(), 1);

    }
    @Test
    public void testSet() {
        ImmutableLinkedList list = new ImmutableLinkedList();
        list  = list.addAll(new Object[] {1, 2, 3, 4});
        assertArrayEquals(list.set(1, 4).toArray(), new Object[] {1, 4, 3, 4});
    }

    @Test
    public void testString() {
        list = list.addAll(new Object[] {1, 2, 3, 4});
        assertEquals(list.toString(), "[1, 2, 3, 4]");
    }

    @Test
    public void testRemove() {
        list = list.addAll(new Object[] {1, 2, 3, 4});
        assertArrayEquals(list.removeLast().toArray(), new Object[] {1, 2, 3});
        assertArrayEquals(list.removeFirst().toArray(), new Object[] {2, 3, 4});
    }


    
}
