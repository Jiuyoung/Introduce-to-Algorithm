package cn.jiuyoung;

import java.util.Arrays;

/**
 * MaxPriorityQueue
 * 《算法导论》中使用的是直接在数组上建立堆，遍历所有的父结点，使得满足大顶堆的要求
 * 这里使用的是插入的方式，从空队列开始，每次插入一个元素，并找到它在大顶堆中的位置
 */
public class MaxPriorityQueue {

    private int[] queue;
    //当前存入的数据个数，从索引为1的位置开始存储
    private int amount = 0;

    public MaxPriorityQueue(int maxCapacity) {
        queue = new int[maxCapacity + 1];
    }

    public static void main(String[] args) {
        int[] a = {3, 432, 535, 162, 34, 64, 755, 7};
        MaxPriorityQueue pq = new MaxPriorityQueue(a.length);
        for (int i : a) {
            pq.insert(i);
        }
        System.out.println("创建队列完成!");
        System.out.println("调用extractMax(): " + pq.extractMax());
        System.out.println("调用maximum(): " + pq.maximum());
        System.out.println("调用insert(700) ");
        pq.insert(700);
        System.out.println("调用maximum(): " + pq.maximum());

    }

    /**
     * 每次插入一个元素并保证满足大顶堆的性质 
     * @param x
     */
    public void insert(int x) {
        queue[++amount] = x;
        swim(amount);
    }

    /**
     * 返回最大的元素
     * @return 大顶堆堆顶的元素
     */
    public int maximum() {
        return amount >= 1 ? queue[1] : Integer.MIN_VALUE;
    }

    /**
     * 返回最大的元素并删除
     * @return 最大的元素
     */
    public int extractMax() {
        if (amount < 1)
            return Integer.MIN_VALUE;
        int max  = maximum();
        queue[1] = queue[amount];
        amount--;
        sink(1);
        return max;
    }

    /**
     * 上浮，使后面的元素上浮来满足大顶堆的性质
     * @param position
     */
    private void swim(int position) {
        int parent = position / 2;
        while (position > 1 && queue[parent] < queue[position]) {
            //原地置换两个数据
            queue[parent]   = queue[parent] + queue[position];
            queue[position] = queue[parent] - queue[position];
            queue[parent]   = queue[parent] - queue[position];
            position        = parent;
            parent          = position / 2;
        }
    }

    /**
     * 下沉，使加入到上部的元素下沉来满足大顶堆的性质
     * @param position
     */
    private void sink(int position) {
        while (position * 2 <= amount) {
            int k = position * 2;
            //判断是否只有左孩子，如果没有右孩子则最大值是左孩子
            if (k < amount && queue[k] < queue[k + 1])
                k += 1;
            if (queue[position] >= queue[k])
                return;
            queue[position] = queue[position] + queue[k];
            queue[k]        = queue[position] - queue[k];
            queue[position] = queue[position] - queue[k];
            position = k;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}