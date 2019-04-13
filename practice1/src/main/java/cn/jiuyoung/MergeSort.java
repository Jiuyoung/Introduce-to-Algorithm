package cn.jiuyoung;

/**
 * Merge
 */
public class MergeSort {

    //辅助数组
    private static int[] auxiliaryArray;

    public static void sort(int[] a) {
        auxiliaryArray = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lower, int hight) {
        if (hight <= lower) return;
        int mid = (lower + hight) / 2;
        sort(a, lower, mid);
        sort(a, mid + 1, hight);
        merge(a, lower, mid, hight);
    }

    /**
     * 合并两个子数组
     * @param a
     * @param lower
     * @param mid
     * @param hight
     */
    private static void merge(int[] a, int lower,int mid, int hight) {
        int i = lower, j = mid + 1;

        for (int k = lower; k <= hight; k++) {
            auxiliaryArray[k] = a[k];
        }

        for (int k = lower; k <= hight; k++) {
            if (i > mid) { //左边已经结束
                a[k] = auxiliaryArray[j++];
            }
            else if (j > hight) { //右边已经结束
                a[k] = auxiliaryArray[i++];
            }
            else if (auxiliaryArray[j] < auxiliaryArray[i]) { //右边小于左边
                a[k] = auxiliaryArray[j++];
            }
            else {             //左边小于右边
                a[k] = auxiliaryArray[i++];
            }
        }
    }

    public static void merge(int[] temp, int[] a, int[] b) {
        int i = 0, j = 0;
        for(int k = 0; k < temp.length - 1; k++) {
            if (i >= a.length) {
                temp[k] = b[j];
            }
            else if (j >= b.length) {
                temp[k] = a[i];
            }
            else if (a[i] > b[j]) {
                temp[k] = b[j++];
            }
            else {
                temp[k] = a[i++];
            }
        }
    }
}