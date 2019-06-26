package cn.jiuyoung;

/**
 * QueenProblem
 */
public class QueenProblem {

    private int[] result;
    private boolean hasResult;

    public QueenProblem(int n) {
        result = new int[n];
        hasResult = false;
    }

    public static void main(String[] args) {
        QueenProblem qp = new QueenProblem(8);
        qp.place(0);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == qp.result[i]) {
                    System.out.printf("%3s", " * ");
                }
                else {
                    System.out.printf("%3s", " | ");
                }
            }
            System.out.println();
        }
        for(int i = 0; i < 8; i++) {
            System.out.print(qp.result[i] + " ");
        }
    }

    public void place(int n) {
        if(n == result.length) {
            hasResult = true;
            return;
        }
        for (int i = 0; i < result.length && !hasResult; i++) {
            result[n] = i;
            if (judge(n)) {
                place(n + 1);
            }
        }
    }

    public boolean judge(int n) {
        for(int i = 0; i < n; i++) {
            if(result[n] == result[i] || Math.abs(n - i) == Math.abs(result[n] - result[i])) {
                return false;
            }
        }
        return true;
    }
}