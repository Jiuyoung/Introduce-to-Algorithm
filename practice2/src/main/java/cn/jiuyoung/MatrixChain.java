package cn.jiuyoung;

/**
 * MatrixChain
 */
public class MatrixChain {

    private int[][] m;
    private int[][] s;
    private int[]   p; 
    private int     n;

    public MatrixChain(int[] p) {
        n = p.length -1;
        m = new int[n + 1][n + 1];//m[1..n,1..n]
        s = new int[n][n + 1]; //s[1..n-1, 2..n]
        this.p = p;
        matrixChainOrder();
    }
    /**
     * 返回最优的乘法次数
     * @return 最好的代价
     */
    public int getOptimalCoast() {
        return m[1][n];
    }
    /**
     * 构造并返回最优划分的字符串表示
     * @return 最优划分的字符串表示
     */
    public String optimalParens2String() {
        //StringBuilder str = new StringBuilder("The optimal partition is: ");
        StringBuilder str = new StringBuilder();
        this.optimalParens(1, n, str);
        return str.toString();
    }
    /**
     * 自底向上计算辅助表m和s
     * @param p
     * @param m
     * @param s
     */
    private void matrixChainOrder() {
        for(int i = 0; i <= n; i++) {
            m[i][i] = 0;
        }
        for(int l = 2; l <= n; l++) {
            for(int i = 1;i <= n - l + 1; i++) {
                int j = i + l -1;
                m[i][j] = Integer.MAX_VALUE;//默认不超过int最大范围
                for(int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if(q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }
    /**
     * 递归构造最优划分
     * @param i 开头矩阵的序号
     * @param j 结束矩阵的序号
     * @param str 
     */
    private void optimalParens(int i, int j, StringBuilder str) {
        if(i == j) {
            str.append("A").append(i);
        }
        else {
            str.append('(');
            optimalParens(i,           s[i][j], str);
            optimalParens(s[i][j] + 1,       j, str);
            str.append(')');
        }
    }
}