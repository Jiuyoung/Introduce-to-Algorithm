package cn.jiuyoung;

/**
 * LCSubstring
 * 使用动态规划的思想，类似于LCSubsequence，只不过当判断到X[i] != Y[j]时，直接将当前单元格置为0.
 */
public class LCSubstring {
    private String str;
    private char[]   X;
    private char[]   Y;
    private int[][]  c;

    public LCSubstring(String x, String y) {
        X   = x.toCharArray();
        Y   = y.toCharArray();
        c   = new int[x.length() + 1][y.length() + 1];
        str = "";
    }

    public static void main(String[] args) {
        String x1 = "xzyzzyx", x2 = "zxyyzxz";
        String y1 = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD";
        String y2 = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG";
        LCSubstring lcsx = new LCSubstring(x1, x2);
        LCSubstring lcsy = new LCSubstring(y1, y2);
        lcsx.execute();
        lcsy.execute();
        System.out.println(x1);
        System.out.println(x2);
        System.out.println("的最长公共子串为：" + lcsx.getResult());
        System.out.println(y1);
        System.out.println(y2);
        System.out.println("的最长公共子串为：" + lcsy.getResult());
    }

    /**
     * 执行程序
     */
    public void execute() {
        int maxlen =        0,
            start  =        0,
            m      = X.length,
            n      = Y.length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(X[i] == Y[j]){
                    c[i + 1][j + 1] = c[i][j] + 1;
                    /**
                     * 以下的判断中，如果没有等于的条件，当有多个长度相同的LCS时会标记遇到的第一个
                     * 如果加入等于的判断条件，就会返回最后一个匹配到的子串
                     */
                    if(c[i + 1][j + 1] >= maxlen) {
                        maxlen = c[i + 1][j + 1];
                        start  = i - maxlen + 1;
                    }
                }
            }
        }
        str = new String(X, start, maxlen);
    }

    /**
     * 返回计算得到的结果
     * @return 最长公共子串中的一个
     */
    public String getResult() {
        return str;
    }
}