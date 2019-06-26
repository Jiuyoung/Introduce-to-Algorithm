package cn.jiuyoung;

import java.util.Arrays;

/**
 * KnapsackProblem0or1
 */
public class KnapsackProblem {

    
    public static void main(String[] args) {
        Item[] items = {
            new Item(20, 10, 2),
            new Item(30, 20, 1.5),
            new Item(65, 30, 2.1),
            new Item(40, 40, 1),
            new Item(60, 50, 1.2)
        };
        KnapsackProblem kp = new KnapsackProblem();
        for(Item item : items) {
            System.out.println(item);
        }
        int[][] c = kp.dpKnapsack(items, 100);
        System.out.println("0/1背包选取的物品是: ");
        int i = items.length, j = 100;
        while(i > 0) {
            if(c[i][j] == c[i - 1][j - items[i - 1].weight < 0 ? 0 : j - items[i - 1].weight] + items[i - 1].value) {
                System.out.println(items[i - 1].toString());
                j -= items[i - 1].weight;
            }
            i--;
        }
        System.out.println("选取的最大价值是: " + c[items.length][100]);
        System.out.println();
        double[] x = kp.fractionalKnapsack(items, 100);
        double maxvalue = 0;
        for (int k = 0; k < items.length; k++) {
            maxvalue += items[k].value * x[k];
            System.out.println(items[k].toString() + "   " + x[k]);
        }
        System.out.println("分数背包选取的最大价值是: " + maxvalue);
    }

    public double[] fractionalKnapsack(Item[] p, double w) {
        Arrays.sort(p);
        for (Item item : p) {
            System.out.println(item);
        }
        int n = p.length;
        double c = w;
        double[] x = new double[n];
        int i = 0;
        for(; i < n; i++) {
            if(p[i].weight < c) {
                x[i] = 1;
                c -= p[i].weight;
            }
            else
                break;
        }
        if (i <= n -1) {
            x[i] = c / p[i].weight;
        }
        return x;
    }

    public int[][] dpKnapsack(Item[] p, int w) {
        int n = p.length;
        int[][] c = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j < p[i - 1].weight) {
                    c[i][j] = c[i - 1][j];
                }
                else {
                    c[i][j] = Math.max(c[i - 1][j], c[i - 1][j - p[i - 1].weight < 0 ? 0 : j - p[i - 1].weight] + p[i - 1].value);
                }
            }
        }
        return c;
    }

    static class Item implements Comparable<Item> {

        int value;
        int weight;
        double ratio;

        public Item(int v, int w, double r) {
            value = v;
            weight = w;
            ratio = r;
        }

        @Override
        public String toString() {
            return "value " + value + " weight " + weight + " ratio " + ratio;
        }

        @Override
        public int compareTo(Item o) {
            double x = o.ratio - this.ratio;
            return x < 0 ? -1 : (x == 0 ? 0 : 1);
        }
    }
}