package cn.jiuyoung;

/**
 * MaxSum
 */
public class MaxSum {

    private int[]   p;
    private int[]   r;//辅助数组，存储p[0~i-1]的和
    private int   max;

    public MaxSum(int[] p) {
        this.p   =                 p;
        this.max =                 0;
        this.r   = new int[p.length];
    }

    public void execute() {
        int n = p.length;
        r[0]  = p[0];
        for(int i = 1; i < n; i++) {
            r[i] = Math.max(r[i - 1] + p[i], p[i]);
            max  = Math.max(           r[i], max);
        }
    }

    public int getResult() {
        return max;
    }
}