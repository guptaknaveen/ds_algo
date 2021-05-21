package com.s2p.practice.leetcode.problems._01500_01600.kthpositive;

/**
 * 1539 : https://leetcode.com/problems/kth-missing-positive-number/
 */
public class Solution {
    public int findKthPositive(int[] arr, int k) {
        int ci = 0, expectedValue = 1, noOfMissing = 0;
        int size = arr.length;

        while (true) {
            if (ci < size && expectedValue == arr[ci]) {
                ci++;
            } else {
                noOfMissing++;
            }

            if (noOfMissing == k) {
                break;
            }

            expectedValue++;
        }
        return expectedValue;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().findKthPositive(new int []{2,3,4,7,11}, 5));
        System.out.println(new Solution().findKthPositive(new int []{1,2,3,4}, 2));
    }
}
