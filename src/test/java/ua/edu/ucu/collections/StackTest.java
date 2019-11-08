package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testPop() {
        Stack stack = new Stack(new Object[] {1, 2, 3});
        assertEquals(stack.peek(), 3);
    }

    @Test
    public void testDeque() {
        Stack stack = new Stack(new Object[] {1, 2, 3});
        stack.push(4);
        assertEquals(stack.toString(), "[4, 1, 2, 3]");
    }

    @Test
    public void testEnqueue() {
        Stack stack = new Stack(new Object[] {1, 2, 3});
        stack.pop();
        assertEquals(stack.toString(), "[1, 2]");

        Stack stack1 = new Stack();
        stack1.push(4);
        assertEquals(stack1.toString(), "[4]");
    }

}
    

