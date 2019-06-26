package cn.jiuyoung;

/**
 * SingleSourcePath
 */
public class SingleSourcePath {

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        Node[] nodes = {
            new Node(),
            new Node(),
            new Node(),
            new Node(),
            new Node()
        };
        boolean t = true;
        int[][] l = {
            {  0,  -1,   3, max, max},
            {max,   0,   3,   2,   2},
            {max, max,   0, max, max},
            {max,   1,   5,   0, max},
            {max, max, max,  -3,   0}
        };
        nodes[0].distance = 0;
        int[][] edges = {
            {0, 1}, {0, 2},
            {1, 2}, {1, 3}, {1, 4},
            {3, 1}, {3, 2},
            {4, 3}
        };
        for (int i = 0; i < l.length; i++) {
            for (int[] edge : edges) {
                relax(nodes, edge, l);
            }
        }
        for(int[] edge : edges) {
            Node v = nodes[edge[1]], u = nodes[edge[0]];
            if(v.distance > u.distance + l[edge[0]][edge[1]]) {
                System.out.println("图中存在权重为负值的环路。");
                t = false;
                break;
            }
        }



        if(t) {
            int startnode = 'A';
            for (int i = 1; i < nodes.length; i++) {
                System.out.println("A 到 " + (char)(startnode + i) + " 的最短路径长度为: " + nodes[i].distance);
                int j = i;
                System.out.print((char)(startnode +i));
                while(nodes[j].pre != -1) {
                    System.out.print(" <- ");
                    System.out.print((char)(startnode + nodes[j].pre));
                    j = nodes[j].pre;
                }
                System.out.println();
            }
        }
    }

    public static void relax(Node[] nodes,int[] edge, int[][] l) {
        Node v = nodes[edge[1]], u = nodes[edge[0]];
        if (v.distance > u.distance + l[edge[0]][edge[1]]) {
            v.distance = u.distance + l[edge[0]][edge[1]];
            v.pre = edge[0];
        }
    }

    static class Node {
        int distance;
        int pre;

        public Node() {
            distance = Integer.MAX_VALUE;
            pre = -1;
        }
    }
}