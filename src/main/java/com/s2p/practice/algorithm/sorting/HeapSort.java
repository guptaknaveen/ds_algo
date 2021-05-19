package com.s2p.practice.algorithm.sorting;

public class HeapSort {

    private void minHeapify(int arr[], int i, int n) {
        int l = 2*i + 1;
        int r = 2*i + 2;
        int p = i, smallest = i;

        int left, right;
        left = right = Integer.MAX_VALUE;

        if (l >= n && r >= n) {
            return;
        }

        if (l < n) {
            left = arr[l];
        }

        if (r < n) {
            right = arr[r];
        }

        if (right < arr[smallest]) {
            smallest = r;
        }

        if (left < arr[smallest]) {
            smallest = l;
        }

        if (smallest == p) {
            return;
        }

        swap(arr, p, smallest);

        minHeapify(arr, smallest, n);
    }


    private void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void heapSort(int arr[]) {
        int size = arr.length;
        int n = size/2 - 1;

        for (int i = n; i>=0; i--) {
            minHeapify(arr, i, size);
        }

        for (int i = size - 1; i>=0; i--) {
            swap(arr, 0, i);
            minHeapify(arr, 0, i);
        }
    }

    private static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(" " + i + " ");
        }
    }

    public static void main(String[] args) {
        int input[] = {2,8,3,6,9,1};
        printArray(input);
        new HeapSort().heapSort(input);
        System.out.println();
        printArray(input);
    }
}
