package com.s2p.practice.leetcode.problems._00200_00300.firstBadVersion;

/**
 * /problems/first-bad-version/
 * 278. First Bad Version
 */
public class Solution {
    private boolean isBadVersion(int n) {
        int a = (int) (Math.random()*10);

        if (a > 3) {
            return true;
        }
        return false;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstBadVersion(5));
    }
}
