package cn.jiuyoung;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * MaxPriorityQueue
 */
public class MaxPriorityQueueTest {

    @Test
    public void testPriorityQueue() {
        int[] a = {3, 432, 535, 162, 34, 64, 755, 7};
        MaxPriorityQueue queue = new MaxPriorityQueue(a.length);
        for (int t : a) {
            queue.insert(t);
        }
        assertEquals(755, queue.extractMax());
        assertEquals(535, queue.maximum());
    }
}