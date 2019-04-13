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
    @Test
    public void testMerge() {
        int[] a = {3, 432, 535, 162, 34, 64, 755, 7};
        FindSum.MergeSort.sort(a);
        assertTrue(isSorted(a));
    }

    

    public boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
