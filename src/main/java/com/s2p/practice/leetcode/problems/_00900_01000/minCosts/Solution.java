package com.s2p.practice.leetcode.problems._00900_01000.minCosts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * /problems/minimum-cost-for-tickets/
 * 983. Minimum Cost For Tickets
 */
public class Solution {
    private int[] COSTS;
    private Map<Integer, Integer> CACHE;
    private Set<Integer> DAYSET;

    public int mincostTickets(int[] days, int[] costs) {
        this.COSTS = costs;
        CACHE = new HashMap<>();
        DAYSET = new HashSet();
        for (int d: days) {
            DAYSET.add(d);
        }

        return dp(1, days[days.length -1]);
    }

    public int dp(int i, int maxDays) {
        if (i > maxDays)
            return 0;
        if (CACHE.get(i) != null)
            return CACHE.get(i);

        int result;
        if (DAYSET.contains(i)) {
            result = Math.min(dp(i+1, maxDays) + COSTS[0],
                    dp(i+7, maxDays) + COSTS[1]);
            result = Math.min(result, dp(i+30, maxDays) + COSTS[2]);
        } else {
            result = dp(i+1, maxDays);
        }

        CACHE.put(i, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mincostTickets(
                new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));

        System.out.println(new Solution().mincostTickets(
                new int[]{1,2,3,4,5,6,7,8,9,10,30,31}, new int[]{2,7,15}));
    }
}
