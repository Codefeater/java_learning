package com.nifx.book;

import java.util.Arrays;

public class Quick {
	public static void sort(int[] a){
		sort(a, 0, a.length -1);
	}
	public static void sort(int[] a, int lo, int hi){
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);		
	}
	private static int partition(int[] a, int lo, int hi){
		int i = lo, j = hi + 1;
		int v = a[lo];
		while (true){
			while (a[++i] < v) if (i == hi) break;
			while (v < a[--j]) if (j == lo) break;
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	private static void exch(int[] a, int i, int j){
		int t = a[i]; a[i] = a[j]; a[j] = t;
	}

	public static void main(String[] args) {
		int[] testcase = new int[]{10,2,3,6,3,2,5,7,4,10,2,3,6,3,2,5,7,4,31,41,41,2,43,5,4,6,7,5};
		Quick.sort(testcase);
		System.out.println(Arrays.toString(testcase));
	}

}
