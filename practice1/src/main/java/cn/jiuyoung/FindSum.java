package cn.jiuyoung;

public class FindSum {

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
}
