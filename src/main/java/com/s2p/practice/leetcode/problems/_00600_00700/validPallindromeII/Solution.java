package com.s2p.practice.leetcode.problems._00600_00700.validPallindromeII;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 * 680. Valid Palindrome II
 */
public class Solution {
    public boolean validPalindrome(String s) {
        if (palindrome(s)) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (true) {
            if (start > end) {
                break;
            }
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                if (palindrome(s.substring(start + 1, end + 1))) {
                    return true;
                }
                if (palindrome(s.substring(start, end))) {
                    return true;
                }
                return false;
            }
        }

        return true;
    }

    private boolean palindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (true) {
            if (start > end) {
                break;
            }
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().validPalindrome("aba"));
//        System.out.println(new Solution().validPalindrome("abca"));
        System.out.println(new Solution().validPalindrome("abc"));
    }
}
