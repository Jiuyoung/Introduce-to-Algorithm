package cn.jiuyoung;

public class FindSum {

    static int[] result = new int[2];

    public static void main(String[] args) {
        int[] test1 = {3, 432, 535, 162, 34, 64, 755, 7};
        int   sum1 = 226;
        int   sum2 = 534;

        if(FindSum.findSum(test1, sum1)) {
            System.out.println("集合中有两个数的和为: " + sum1 + " = " + result[0] + " + " + result[1]);
        }
        else {
            System.out.println("集合中没有两个数的和为: " + sum1);
        }

        if(FindSum.findSum(test1, sum2)) {
            System.out.println("集合中有两个数的和为: " + sum2 + " = " + result[0] + " + " + result[1]);
        }
        else {
            System.out.println("集合中没有两个数的和为: " + sum2);
        }
    }

    
    public static boolean findSum(int[] a, int sum) {
        //归并排序 时间复杂度为nlowergn
        MergeSort.sort(a);
        //双向扫描 时间复杂度为n
        /**
         * 当a[lower] + a[hight] 的值等于sum时返回true，否则判断它和sum的大小关系
         * 如果它大于sum，则将hight的值减一，否则将lower的值加一
         * 循环结束条件为lower == hight，此时整个数组扫描完成
         */
        int lower = 0, hight = a.length - 1;
        while(lower != hight) {
            int t = a[lower] + a[hight];
            if(t == sum) {
                result[0] = a[lower];
                result[1] = a[hight];
                return true;
            }
            else if (t > sum) {
                hight--;
            }
            else {
                lower++;
            }
        }
        return false;
    }
    static class MergeSort {

        //辅助数组
        private static int[] auxiliaryArray;
    
        public static void sort(int[] a) {
            auxiliaryArray = new int[a.length];
            sort(a, 0, a.length - 1);
        }
    
        private static void sort(int[] a, int lower, int hight) {
            if (hight <= lower) return;
            int mid = (lower + hight) / 2;
            sort(a,   lower,   mid);
            sort(a, mid + 1, hight);
            merge(a,  lower, mid, hight);
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
            for(int k = 0; k < temp.length; k++) {
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
}
