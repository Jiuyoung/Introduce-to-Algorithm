package cn.jiuyoung;

/**
 * QuickSort
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {3, 432, 535, 162, 34, 64, 755, 7};
        System.out.println("未排序序列为：");
        for(int i : a) {
            System.out.print(i + "  ");
        }
        System.out.println();
        QuickSort.sort(a);
        System.out.println("已排序序列为：");
        for(int i : a) {
            System.out.print(i + "  ");
        }
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int startIndex, int endIndex) {
        if(startIndex < endIndex) {
            int q = patition(a, startIndex, endIndex);
            sort(a, startIndex,        q - 1);
            sort(a,      q + 1,     endIndex);
        }
    }

    private static int patition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for(int j = p; j < r; j++) {
            if(a[j] <= x){
                i += 1;
                if(i != j) {
                    a[i] = a[i] + a[j];
                    a[j] = a[i] - a[j];
                    a[i] = a[i] - a[j];
                }
            }
        }
        a[i + 1] = a[r]     + a[i + 1];
        a[r]     = a[i + 1] - a[r];
        a[i + 1] = a[i + 1] - a[r];
        return i + 1;
    }

}