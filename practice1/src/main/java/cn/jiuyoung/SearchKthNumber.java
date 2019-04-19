package cn.jiuyoung;

/**
 * SearchKthNumber
 * 利用二分查找的思想，每次排除一个数组的一半，直到一个数组全部被划分完，此时，需要找的这个数在另一个数组中。
 * 给定的数组是从小到大排序，所以将找第K大元素转换为第K小。
 */
public class SearchKthNumber {

    public static int Search(int[] a, int[] b, int k) {

        //转换为找第K小的数
        k = a.length + b.length - k + 1;
        if(a.length + b.length < k) 
            return 0;
        else
            return Search(a, 0, a.length - 1, b, 0, b.length - 1, k);
    }

    private static int Search(int[] a, int aLower, int aHigh, int[] b, int bLower, int bHigh, int k) {
        if(aLower > aHigh)
            return b[bLower + k - 1];
        if(bLower > bHigh) 
            return a[aLower + k - 1];
        if(aHigh - aLower + bHigh - bLower + 2 == k)
            return a[aHigh] > b[bHigh] ? a[aHigh] : b[bHigh];
        //求取两个数组中间位
        int aHalf = aLower + (aHigh - aLower) / 2;
        int bHalf = bLower + (bHigh - bLower) / 2;
        //ab数组在划分左边的所有元素的个数，用来判断k所处的范围
        int half = aHalf - aLower + bHalf - bLower + 2;
        if(a[aHalf] > b[bHalf]) {
            if(half > k) 
                return Search(a, aLower, aHalf - 1, b, bLower, bHigh, k);
            else 
                return Search(a, aLower, aHigh, b, bHalf + 1, bHigh, k-(bHalf - bLower + 1));
        }
        else {
            if(half > k)
                return Search(a, aLower, aHigh, b, bLower, bHalf - 1, k);
            else 
                return Search(a, aHalf + 1, aHigh, b, bLower, bHigh, k - (aHalf - aLower + 1));
        }
    }
}