package cn.jiuyoung;

import java.util.Arrays;
import java.util.Stack;

/**
 * ShortestPath
 * 两点之间的最短路径(动态规划)
 */
public class ShortestPath {

    //记录路径长度
    private int[] d;
    //邻接矩阵表示图
    private int[][] distance;
    //保存路径
    private int[] path;

    public ShortestPath(int[][] distance) {
        this.distance = distance;
        d = new int[distance.length];
        path = new int[distance.length];
        Arrays.fill(d, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        int[][] n = {
            {0, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 8, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 6, 8, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 3, 5, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 8, 4, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 2, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        ShortestPath shortestPath = new ShortestPath(n);
        shortestPath.execute();
        System.out.println(shortestPath.getResult());
    }

    public void execute() {
        d[0] = 0;
        for(int i = 0; i < distance.length; i++) {
            for(int j = 0; j < distance.length; j++) {
                if(distance[i][j] != 0) {
                    int len = d[i] + distance[i][j];
                    if(len < d[j]) {
                        d[j] = len;
                        path[j] = i;
                    }
                }
            }
        }
    }

    public String getResult() {
        StringBuilder builder = new StringBuilder();
        Stack<Integer> pStack = new Stack<>();
        pStack.push(path.length - 1);
        int i = path.length - 1;
        while(path[i] != 0) {
            pStack.push(path[i]);
            i = path[i];
        }
        pStack.push(0);
        while(!pStack.empty()) {
            builder.append(pStack.pop()).append(" ");
        }
        builder.append("shortest length is ").append(d[d.length - 1]);
        return builder.toString();
    }
}