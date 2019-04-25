package cn.jiuyoung;

/**
 * LCSubsequence
 */
public class LCSubsequence {

    private char[]          X;
    private char[]          Y;
    private int[][]         c;
    private char[][]        b;
    private boolean isExecute;

    public LCSubsequence(String x, String y) {
        X = x.toCharArray();
        Y = y.toCharArray();
        c = new  int[x.length() + 1][y.length() + 1];
        b = new char[x.length() + 1][y.length() + 1];
        isExecute = false;
    }

    public void execute() {
        int m = X.length, n = Y.length;
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
        isExecute = true;
    }

    public String getResult() {
        if(!isExecute)
            return "";
        StringBuilder builder = new StringBuilder();
        printLCS(builder, X.length, Y.length);
        return builder.toString();
    }

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
        else 
            printLCS(str,     i, j - 1);
    }
}