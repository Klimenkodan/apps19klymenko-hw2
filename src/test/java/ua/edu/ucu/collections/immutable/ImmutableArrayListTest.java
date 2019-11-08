package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    ImmutableArrayList list = new ImmutableArrayList();
    @Test
    public void testAdd() {
        ImmutableArrayList list1 = list.add(1);
        assertArrayEquals(list1.toArray(), new Object[] {1});
        ImmutableArrayList list2 = list1.add(2);
        assertArrayEquals(list2.toArray(), new Object[] {1, 2});
        list2 = list2.add(4).add(5).add(1, 3);
        assertArrayEquals(list2.toArray(), new Object[] {1, 3, 2, 4, 5});

    }

    @Test
    public void testAddAll() {
        ImmutableArrayList list1 = list.addAll(new Object[] {1, 2, 3, 4, 5});
        assertArrayEquals(list1.toArray(), new Object[] {1, 2, 3, 4, 5});
        list1 = list1.addAll(2, new Object[] {6, 7, 8});
        assertArrayEquals(list1.toArray(), new Object[] {1, 2, 6, 7, 8, 3, 4, 5});
    }

    @Test
    public void testClear() {
        ImmutableArrayList list1 = list.add(1);
        ImmutableArrayList list2 = list1.clear();
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
        ImmutableArrayList list = new ImmutableArrayList();
        list = list.addAll(new Object[] {1, 2, 3, 4});
        assertEquals(list.get(2), 3);

    }
    @Test
    public void testSet() {
        ImmutableArrayList list = new ImmutableArrayList();
        list  = list.addAll(new Object[] {1, 2, 3, 4});
        assertArrayEquals(list.set(1, 4).toArray(), new Object[] {1, 4, 3, 4});
    }

    @Test
    public void testString() {
        list = list.addAll(new Object[] {1, 2, 3, 4});
        assertEquals(list.toString(), "[1, 2, 3, 4]");
    }

    
}
