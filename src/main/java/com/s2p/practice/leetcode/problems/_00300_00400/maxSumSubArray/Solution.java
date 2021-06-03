package com.s2p.practice.leetcode.problems._00300_00400.maxSumSubArray;

import java.util.HashMap;
import java.util.Map;

/**
 * 325 : /problems/maximum-size-subarray-sum-equals-k/
 */
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {

        int sum = 0, result = 0, n = nums.length;

        Map<Integer, Integer> sumMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];

            if (sum == k) {
                result = Math.max(result, i + 1);
            }

            if (!sumMap.containsKey(sum)) {
                sumMap.put(sum, i);
            }

            if (sumMap.containsKey(sum - k)) {
                result = Math.max(i - sumMap.get(sum - k), result);
            }
        }

        return result;
    }
}