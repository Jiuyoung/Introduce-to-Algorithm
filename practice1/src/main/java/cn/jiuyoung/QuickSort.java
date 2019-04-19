package cn.jiuyoung;

/**
 * QuickSort
 */
public class QuickSort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int p, int r) {
        if(p < r) {
            int q = patition(a, p, r);
            sort(a,     p, q - 1);
            sort(a, q + 1,     r);
        }
    }

    private static int patition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for(int j = p; j < r; j++) {
            if(a[j] <= x){
                i += 1;
                a[i] = a[i] + a[j];
                a[j] = a[i] - a[j];
                a[i] = a[i] - a[j];
            }
        }
        a[i + 1] = a[r] + a[i + 1];
        a[r]     = a[i + 1] - a[r];
        a[i + 1] = a[i + 1] - a[r];
        return i + 1;
    }

}