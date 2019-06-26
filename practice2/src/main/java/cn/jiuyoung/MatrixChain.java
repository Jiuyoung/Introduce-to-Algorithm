package cn.jiuyoung;

/**
 * MatrixChain
 */
public class MatrixChain {

    private int[][]         m;
    private int[][]         s;
    private int[]           p; 
    private int             n;
    private String        str;
    private boolean isExecute;

    public MatrixChain(int[] p) {
        this.n         = p.length -1;
        this.m         = new int[n + 1][n + 1];//m[1..n,1..n]
        this.s         = new int[n][n + 1]; //s[1..n-1, 2..n]
        this.p         = p;
        this.str       = "";
        this.isExecute = false;
    }

    public static void main(String[] args) {
        int[] t1 = {3, 5, 2, 1, 10};
        int[] t2 = {2, 7, 3, 6, 10};
        int[] t3 = {10, 3, 15, 12, 7, 2};
        int[] t4 = {7, 2, 4, 15, 20, 5};
        MatrixChain m1 = new MatrixChain(t1);
        MatrixChain m2 = new MatrixChain(t2);
        MatrixChain m3 = new MatrixChain(t3);
        MatrixChain m4 = new MatrixChain(t4);
        m1.execute();
        m2.execute();
        m3.execute();
        m4.execute();
        print(t1);
        System.out.println("结果为：" + m1.getOptimalParens() + " 乘法次数：" + m1.getOptimalCoast());
        print(t2);
        System.out.println("结果为：" + m2.getOptimalParens() + " 乘法次数：" + m2.getOptimalCoast());
        print(t3);
        System.out.println("结果为：" + m3.getOptimalParens() + " 乘法次数：" + m3.getOptimalCoast());
        print(t4);
        System.out.println("结果为：" + m4.getOptimalParens() + " 乘法次数：" + m4.getOptimalCoast());
    }

    public static void print(int[] t) {
        for (int i : t) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    /**
     * 返回最优的乘法次数
     * @return 最好的代价/没有执行时返回-1
     */
    public int getOptimalCoast() {
        return isExecute ? m[1][n] : -1;
    }
    /**
     * 构造并返回最优划分的字符串表示
     * @return 最优划分的字符串表示/没有执行时返回为空字符串
     */
    public String getOptimalParens() {
        
        return str;
    }
    /**
     * 自底向上计算辅助表m和s
     */
    public void execute() {
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
        StringBuilder builder = new StringBuilder();
        this.optimalParens(1, n, builder);
        this.str = builder.toString();
        isExecute = true;
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
            optimalParens(          i, s[i][j], str);
            optimalParens(s[i][j] + 1,       j, str);
            str.append(')');
        }
    }
}