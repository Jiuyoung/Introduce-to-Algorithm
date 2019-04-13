package cn.jiuyoung;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * SearchKthNumberTest
 */
public class SearchKthNumberTest {

    @Test
    public void testSearchKthNumber() {
        int[] a = {1, 23, 56, 78, 90, 139, 26666, 335576};
        int[] b = {2, 4, 57, 88, 94, 290, 34343666};
        int[] aAndB = new int[a.length + b.length];
        FindSum.MergeSort.merge(aAndB, a, b);
        assertEquals(aAndB[12 - 1], SearchKthNumber.Search(a, b, 12));
    }
}