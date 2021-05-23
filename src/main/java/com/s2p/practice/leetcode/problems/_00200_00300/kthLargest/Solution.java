package com.s2p.practice.leetcode.problems._00200_00300.kthLargest;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 215. Kth Largest Element in an Array
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
//        return findKthLargestBySorting(nums, k);
        return findKthLargestByHeap(nums, k);
    }

    public int findKthLargestBySorting(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        int result = -1;

        Arrays.sort(nums);

        int size = nums.length;

        for (int i = 0; i<k; i++) {
            result = nums[size - i - 1];
        }
        return result;
    }

    public int findKthLargestByHeap(int[] nums, int k) {
        int result = -1;
        int size = nums.length;
        for (int i = 0; i<k; i++) {
            heapify(nums, size - i - 1);
            result = nums[0];
            nums[0] = nums[size - i - 1];
            nums[size - i - 1] = result;
        }
        return result;
    }

    private void heapify(int[] nums, int size) {
        int left, right, parent;
        int i = (size - 1) / 2;

        for (;i>=0;i--) {
            parent = nums[i];
            left = nums[2*i + 1];

            if (2*i + 1 >= nums.length || 2*i + 1 > size) {
                continue;
            }

            if (left > parent) {
                nums[i] = left;
                nums[2*i + 1] = parent;
                parent = left;
            }

            if (2*i + 2 >= nums.length || 2*i + 2 > size) {
                continue;
            }

            right = nums[2*i + 2];

            if (right > parent) {
                nums[i] = right;
                nums[2*i + 2] = parent;
            }
        }
    }

    public int findKthLargestUsingPriorityQueue(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(new Solution().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
