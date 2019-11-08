package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testPeek() {
        Queue que = new Queue(new Object[] {1, 2, 3});
        assertEquals(que.peek(), 1);
        Queue que1 = new Queue();
        que1.enqueue(4);
        assertEquals(que1.toString(), "[4]");
    }

    @Test
    public void testDeque() {
        Queue que = new Queue(new Object[] {1, 2, 3});
        que.dequeue();
        assertEquals(que.toString(), "[2, 3]");
    }

    @Test
    public void testEnqueue() {
        Queue que = new Queue(new Object[] {1, 2, 3});
        que.enqueue(4);
        assertEquals(que.toString(), "[1, 2, 3, 4]");
    }
    
}
