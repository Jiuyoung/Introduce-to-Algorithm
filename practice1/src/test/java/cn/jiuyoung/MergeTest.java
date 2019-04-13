package cn.jiuyoung;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * MergeTest
 */
public class MergeTest {

    @Test
    public void testMerge() {
        int[] a = {3, 432, 535, 162, 34, 64, 755, 7};
        MergeSort.sort(a);
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