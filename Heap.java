package com.com.immoc.nfx;

/**
 * Created by feixiang.nfx on 2017/7/30.
 */
public class HeapSort {
    private int[] data;
    private int count;

    private void exch(int a, int b) {
        int tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }

    private void swim(int k) {
        while (k > 1 && data[k / 2] < data[k]) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[j] < data[j + 1]) j++;
            if (data[j] <= data[k]) break;
            exch(k,j);
            k = j;
        }
    }

    public int size() {
        return count;
    }

    public HeapSort(int capacity) {
        data = new int[capacity + 1];
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int item) {
        data[++count] = item;
        swim(count);
    }

    public int extractMax() {
        int ret = data[1];
        exch(1, count--);
        sink(1);
        return ret;
    }
}
