package com.s2p.practice.leetcode.problems._00800_00900.binaryTreeWithFactors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    823 : https://leetcode.com/problems/binary-trees-with-factors/
 */
public class Solution {

    public int numFactoredBinaryTrees(int[] A) {
        int MOD = 1_000_000_007;
        int N = A.length;
        Arrays.sort(A);
        long[] dp = new long[N];

        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < N; ++i)
            index.put(A[i], i);

        for (int i = 0; i < N; ++i)
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0) {
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                    }
                }
            }

        long ans = 0;
        for (long x: dp) ans += x;
        return (int) (ans % MOD);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(solution.numFactoredBinaryTrees(new int[]{2,4}));
//        System.out.println(solution.numFactoredBinaryTrees(new int[]{2,4, 5 ,10}));
//        System.out.println(solution.numFactoredBinaryTrees(new int[]{242,315,26,27,16,337,75,371,253,67,105,327,96,373,113,167,3,99,193}));
        System.out.println(solution.numFactoredBinaryTrees(new int[]{46,144,5040,4488,544,380,4410,34,11,5,3063808,5550,34496,12,540,28,18,13,2,1056,32710656,31,91872,23,26,240,18720,33,49,4,38,37,1457,3,799,557568,32,1400,47,10,20774,1296,9,21,92928,8704,29,2162,22,1883700,49588,1078,36,44,352,546,19,523370496,476,24,6000,42,30,8,16262400,61600,41,24150,1968,7056,7,35,16,87,20,2730,11616,10912,690,150,25,6,14,1689120,43,3128,27,197472,45,15,585,21645,39,40,2205,17,48,136}));
//        System.out.println(solution.numFactoredBinaryTrees(new int[]{2,4, 3, 6, 12}));
    }
}
