package com.s2p.practice.leetcode.problems._00500_00600.continuosSubArraySum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 * 523. Continuous Subarray Sum
 */
public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }

        Map<Integer, Integer> prefixSum = new HashMap<>();

        int sum = 0, j = 0;
        for (int i : nums) {
            i = i % k;

            sum = sum + i;

            sum = sum % k;

            if (sum == 0 && j > 0) {
                return true;
            }

            if (prefixSum.containsKey(sum) && j - prefixSum.get(sum) > 2) {
                return true;
            }

            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, j);
            }
            j++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkSubarraySum(
                new int[]{23,2,6,2,5}, 6
        ));

        System.out.println(new Solution().checkSubarraySum(
                new int[]{23,2,6,4,7}, 6
        ));
        System.out.println(new Solution().checkSubarraySum(
                new int[]{23,2,6,4,7}, 13
        ));
        System.out.println(new Solution().checkSubarraySum(
                new int[]{0}, 1
        ));
        System.out.println(new Solution().checkSubarraySum(
                new int[]{5,0,0,0}, 3
        ));
    }
}
