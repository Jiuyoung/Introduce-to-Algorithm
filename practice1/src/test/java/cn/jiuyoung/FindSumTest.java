package cn.jiuyoung;

import static org.junit.Assert.*;

import org.junit.Test;


public class FindSumTest{

    @Test
    public void testFindSum(){
        int[] a = {3, 432, 535, 162, 34, 64, 755, 7};
        assertTrue(FindSum.findSum(a, 226));
        assertFalse(FindSum.findSum(a, 100));
    }
}
