package com.nifx.book;

public class MaxPQ {
	private int[] pq;
	private int N = 0;
	
	public MaxPQ(int MaxN){
		pq = new int[MaxN + 1];
	}
	public boolean isEmpty(){
		return N == 0;
	}
	public void insert(int v){
		pq[++N] = v;
		swim(N);
	}
	public int delMax(){
		int max = pq[1];
		exch(1, N --);
		pq[N + 1] = 0;
		sink(1);
		return max;		
	}
	private void exch(int i, int j){
		int aux = pq[i]; pq[i] = pq[j]; pq[j] = aux;
	}
	private void swim(int k){
		while (k > 1 && pq[k/2] < pq[k]){ // 上升的条件：1.k值合理区间 2.有顶上级的肺的能力
			exch(k/2, k);
			k = k/2;
		}
	}
	private void sink(int k){
		while (2*k < N){ //下沉的条件： 1.合理的区间
			int j = 2*k;
			if (j < N && pq[j] < pq[j + 1]) j ++; // 找寻后继中最大的
			if (pq[k] >= pq[j]) break;  // 合适的位置找到了，我就停止了
			exch(k, j);
			k = j;
		}
	}

	public static void main(String[] args) {
		int[] testcase = new int[]{10,2,3,6,3,5,7,4,10,6,3,5,7,4,31,41,2,43,5,4,6,7,5};
		MaxPQ myTest = new MaxPQ(40);
		for (int i = 0; i < testcase.length; i ++){
			myTest.insert(testcase[i]);
		}
		for (int i = 0; i < testcase.length; i ++){
			System.out.println(myTest.delMax());
		}
	}

}
