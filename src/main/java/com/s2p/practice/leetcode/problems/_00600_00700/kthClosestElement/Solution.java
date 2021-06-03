package com.s2p.practice.leetcode.problems._00600_00700.kthClosestElement;

import java.util.ArrayList;
import java.util.List;

/**
 * /problems/find-k-closest-elements/solution/
 * 658. Find K Closest Elements
 */
public class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Initialize binary search bounds
        int left = 0;
        int right = arr.length - k;

        // Binary search against the criteria described
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // Create output in correct format
        List<Integer> result = new ArrayList<Integer>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution().findClosestElements(new int[]{1,2,3,4,5}, 4, 3)
        );

        System.out.println(
                new Solution().findClosestElements(new int[]{1,2,3,4,5}, 4, -1)
        );
    }
}
