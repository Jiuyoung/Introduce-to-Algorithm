package cn.jiuyoung;

/**
 * LCSubsequence
 */
public class LCSubsequence {

    private String str;
    private char[]   X;
    private char[]   Y;
    private int[][]  c;
    private char[][] b;


    public LCSubsequence(String x, String y) {
        X         = x.toCharArray();
        Y         = y.toCharArray();
        c         = new  int[x.length() + 1][y.length() + 1];
        b         = new char[x.length() + 1][y.length() + 1];
        str       = "";
    }

    /**
     * 返回计算结果
     * @return String 空或者最长公共子序列中的一个
     */
    public String getResult() {
        return str;
    }

    /**
     * 执行程序
     */
    public void execute() {
        int m = X.length;
        int n = Y.length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(X[i] == Y[j]) {
                    c[i + 1][j + 1] = c[i][j] + 1;
                    b[i + 1][j + 1] = 'a';
                }
                else if(c[i][j + 1] >= c[i + 1][j]) {
                    c[i + 1][j + 1] = c[i][j + 1];
                    b[i + 1][j + 1] = 'b';
                }
                else {
                    c[i + 1][j + 1] = c[i + 1][j];
                    b[i + 1][j + 1] = 'c';
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        printLCS(builder, X.length, Y.length);
        this.str = builder.toString();
    }


    /**
     * 递归构造最长公共子序列
     * @param str StringBuilder
     * @param i 
     * @param j
     */
    private void printLCS(StringBuilder str, int i, int j) {
        if(i == 0 || j == 0) {
            return;
        }
        if(b[i][j] == 'a') {
            printLCS(str, i - 1, j - 1);
            str.append(X[i - 1]);
        }
        else if(b[i][j] == 'b') {
            printLCS(str, i - 1,     j);
        }
        else {
            printLCS(str,     i, j - 1);
        }
    }
}