package cn.jiuyoung;

import java.util.Arrays;
/**
 * BKnapsackProblem
 */
public class BKnapsackProblem {

	private Item[] items;
	private float c; // 背包容量
	private float fp;// 最终获得的价值
	private int[] X;// 结果矩阵

	private float nowWeight = 0; // 记录当前重量
	private float nowPrice = 0; // 记录当前价格

	public BKnapsackProblem(Item[] items, float c) {
		this.fp = -1;
		this.items = items;
		this.X = new int[items.length];
		this.c = c;
		Arrays.sort(items);
		for(Item item : items) {
			System.out.println(item);
		}
	}

	public void BKNAP() {
		int[] Y = new int[X.length];
		int k = 0;
		int n = items.length;
		while (true) {
			while (k < n && nowWeight + items[k].weight <= c) {
				nowWeight += items[k].weight;
				nowPrice += items[k].value;
				Y[k] = 1;
				k++;
			}
			if (k >= n) {
				fp = nowPrice;
				k = n - 1;
				arrayCopy(X, Y);
			} else {
				Y[k] = 0;
			}
			while (bound(k) <= fp) {
				while (k + 1 != 0 && Y[k] != 1) {
					k -= 1;
				}
				if (k < 0) {
					return;
				}
				Y[k] = 0;
				nowWeight -= items[k].weight;
				nowPrice -= items[k].value;
			}
			k += 1;
		}
	}

	public void printResult() {
		if (fp != -1) {
			for (int i : X) {
				System.out.print("  " + i + "  ");
			}
			System.out.println(fp);
		}
	}

	public void arrayCopy(int[] x, int[] y) {
		for (int i = 0; i < y.length; i++) {
			x[i] = y[i];
		}
	}

	public float bound(int i) {

		float weight = nowWeight;
		float bound = nowPrice;

		for (int k = i + 1; k < items.length; k++) {
			weight += items[k].weight;
			if (weight < c) {
				bound += items[k].value;
			} else {
				return (bound + (1 - (weight - c) / items[k].weight) * items[k].value);
			}
		}
		return bound;
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

	public static void main(String[] args) {

		Item[] items = { new Item(20, 10, 2), 
						new Item(30, 20, 1.5), 
						new Item(65, 30, 2.1), 
						new Item(40, 40, 1),
						new Item(60, 50, 1.2) };
		float c = 100;
		BKnapsackProblem kp = new BKnapsackProblem(items, c);
		kp.BKNAP();
		kp.printResult();
	}

}
