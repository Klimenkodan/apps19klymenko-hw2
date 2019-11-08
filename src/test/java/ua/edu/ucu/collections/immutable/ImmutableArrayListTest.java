package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    ImmutableArrayList list = new ImmutableArrayList();
    @Test
    public void test_add() {
        ImmutableList list1 = list.add(1);
        assertArrayEquals(list1.toArray(), new Object[] {1});
        ImmutableList list2 = list1.add(2);
        assertArrayEquals(list2.toArray(), new Object[] {1, 2});

    }

    @Test
    public void test_clear() {
        ImmutableList list1 = list.add(1);
        System.out.println(Arrays.toString(list1.toArray()) + " " + list1.size());
        ImmutableList list2 = list1.clear();
        System.out.println(Arrays.toString(list2.toArray()));
        assertArrayEquals(list2.toArray(), new Object[] {});
    }
    @Test
    public void test2() {
    }
    @Test
    public void tes3() {
    }
    @Test
    public void test4() {
    }
    @Test
    public void test5() {
    }
    
}
