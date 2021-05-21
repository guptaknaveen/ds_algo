package com.s2p.practice.leetcode.problems._00400_00500.partitionEqualSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 416 : https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int i : nums) {
            sum+=i;
        }

        if (sum%2!=0) {
            return false;
        }

        return isSumPossible(sum/2, nums, 0);
    }


    private Map<Integer, Map<Integer, Boolean>> CACHE = new HashMap();

    private boolean isSumPossible(int sum, int[] arr, int index) {

        Boolean cacheResult = getFromCache(sum, index);

        if (cacheResult != null) {
            return cacheResult;
        }

        if (index == arr.length || sum < 0) {
            return false;
        }

        if (sum == 0) {
            return true;
        }

        cacheResult =
                isSumPossible(sum - arr[index], arr, index + 1) ||
                        isSumPossible(sum, arr, index + 1);

        putIntoCache(sum, index, cacheResult);

        return cacheResult;

    }

    private Boolean getFromCache(int sum, int index) {
        if (CACHE.get(sum) == null) {
            return null;
        }
        return CACHE.get(sum).get(index);
    }

    private void putIntoCache(int sum, int index, boolean value) {
        if (CACHE.get(sum) == null) {
            CACHE.put(sum , new HashMap());
        }
        CACHE.get(sum).put(index, value);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.canPartition(new int[]{1, 5, 11, 5}));
    }
}