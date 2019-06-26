package cn.jiuyoung;

/**
 * AllPairsPath
 */
public class AllPairsPath {

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int[][] l = {
            {  0,  -1,   3, max, max},
            {max,   0,   3,   2,   2},
            {max, max,   0, max, max},
            {max,   1,   5,   0, max},
            {max, max, max,  -3,   0}
        };
        AllPairsPath ap = new AllPairsPath();
        ap.floyd(l);
    }

    public void arraycopy(int[][] src, int[][] dest) {
        int n = src.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dest[i][j] = src[i][j];
            }
        }
    }

    public void floyd(int[][] w){
        int n = w.length;
        int[][] d = new int[n][n];
        //print(w);
        arraycopy(w, d);
        for(int k = 0; k < n; k++) {
            int[][] d1 = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(d[i][k] != Integer.MAX_VALUE && d[k][j] != Integer.MAX_VALUE) {
                        d1[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }else {
                        d1[i][j] = d[i][j];
                    }
                }
            }
            System.out.println(k);
            print(d1);
            arraycopy(d1, d);
        }
    }
    public void print(int[][] l) {
        int n = l.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(l[i][j] != Integer.MAX_VALUE) {
                    System.out.printf("%2d  ", l[i][j]);
                }else {
                    System.out.print("**" + "  ");
                }
            }
            System.out.println();
        }
        System.out.println("________________________________________________");
    }
}