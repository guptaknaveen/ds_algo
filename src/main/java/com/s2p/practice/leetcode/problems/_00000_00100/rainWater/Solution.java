package com.s2p.practice.leetcode.problems._00000_00100.rainWater;

/*
    42 : /problems/trapping-rain-water/
 */
public class Solution {
    public int trap(int[] height) {
        int size = height.length;

        int left[] = new int[size];
        int right[] = new int[size];

        int lcm = Integer.MIN_VALUE, rcm = Integer.MIN_VALUE;

        for (int i=1; i<size; i++) {
            if (lcm < height[i-1]) {
                lcm = height[i-1];
            }
            if (rcm < height[size-i]) {
                rcm = height[size-i];
            }
            left[i] = lcm;
            right[size-1-i] = rcm;
        }

        int result = 0;


        for (int i = 1; i<size-1; i++) {
            if (Math.min(left[i], right[i]) < height[i]) {
                continue;
            }
            result = result + Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new Solution().trap(new int[]{4,2,0,3,2,5}));
    }
}