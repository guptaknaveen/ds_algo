package com.s2p.practice.leetcode.problems._00500_00600.subArraySumCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /problems/subarray-sum-equals-k/
 * 560. Subarray Sum Equals K
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, List<Integer>> prefixSum = new HashMap<>();

        int size = nums.length, ele, sum = 0;
        int result = 0;
        List<Integer> prefixSumIndex;

        for (int i = 0; i < size; i++) {
            ele = nums[i];
            sum = sum + ele;

            if (sum == k) {
                result++;
            }

            prefixSumIndex = prefixSum.get(sum - k);
            if (prefixSumIndex != null) {
                result = result + prefixSumIndex.size();
            }

            prefixSumIndex = prefixSum.get(sum);
            if (prefixSumIndex == null) {
                prefixSumIndex = new ArrayList<>();
                prefixSum.put(sum, prefixSumIndex);
            }
            prefixSumIndex.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{1,1,1}, 2));
        System.out.println(new Solution().subarraySum(new int[]{1,2,3}, 3));
    }
}
