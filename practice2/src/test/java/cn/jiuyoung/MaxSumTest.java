package cn.jiuyoung;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * MaxSumTest
 */
public class MaxSumTest {

    @Test
    public void testMaxSum() {
        int[] p = {-2, 11, -4, 13, -5, -2};
        MaxSum maxSum = new MaxSum(p);
        maxSum.execute();
        assertEquals(20, maxSum.getResult());
    }
}