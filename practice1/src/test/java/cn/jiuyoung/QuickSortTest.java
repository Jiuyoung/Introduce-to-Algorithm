package cn.jiuyoung;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * QuickSort
 */
public class QuickSortTest {

    @Test
    public void testQuickSort() {
        int[] a = {3, 432, 535, 162, 34, 64, 755, 7};
        QuickSort.sort(a);
        assertTrue(isSorted(a));
    }


    private boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }
}