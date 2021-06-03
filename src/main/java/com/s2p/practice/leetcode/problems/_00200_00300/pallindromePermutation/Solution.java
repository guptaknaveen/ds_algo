package com.s2p.practice.leetcode.problems._00200_00300.pallindromePermutation;

import java.util.HashMap;
import java.util.Map;

/**
 * /problems/palindrome-permutation/
 * 266. Palindrome Permutation
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        int size = s.length();

        if (size == 1) {
            return true;
        }

        Map<Character, Boolean> countMap = new HashMap<>();
        Boolean count;

        for (char ch : s.toCharArray()) {
            count = countMap.get(ch);
            if (count == null) {
                count = true;
                countMap.put(ch, count);
            } else {
                countMap.remove(ch);
            }
        }

        return size%2 == 0 ? countMap.size() == 0 : countMap.size() == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPermutePalindrome("code"));
        System.out.println(new Solution().canPermutePalindrome("aab"));
        System.out.println(new Solution().canPermutePalindrome("carerac"));
    }
}
