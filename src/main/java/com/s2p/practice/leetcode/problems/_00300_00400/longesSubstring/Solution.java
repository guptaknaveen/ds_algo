package com.s2p.practice.leetcode.problems._00300_00400.longesSubstring;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * 340. Longest Substring with At Most K Distinct Characters
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        return lengthOfLongestSubstringKDistinct_slidingwindow(s, k);
    }

    private int lengthOfLongestSubstringKDistinct_leetcode(String s, int k) {
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;

        Map<Character, Integer> rightmostPosition = new LinkedHashMap<>();

        int maxLength = 1;

        while (right < n) {
            Character character = s.charAt(right);
            if (rightmostPosition.containsKey(character)) {
                rightmostPosition.remove(character);
            }
            rightmostPosition.put(character, right++);

            if (rightmostPosition.size() == k + 1) {
                Map.Entry<Character, Integer> leftmost =
                        rightmostPosition.entrySet().iterator().next();
                rightmostPosition.remove(leftmost.getKey());
                left = leftmost.getValue() + 1;
            }

            maxLength = Math.max(maxLength, right - left);
        }
        return maxLength;
    }

    private int lengthOfLongestSubstringKDistinct_slidingwindow(String s, int k) {
        int n = s.length();
        if (n * k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;

        Map<Character, Integer> windowMap = new LinkedHashMap<>();

        int maxLength = 1;

        while (true) {
            if (right == n || left == n) {
                break;
            }

            Character character = s.charAt(right);

            if (windowMap.get(character) == null) {
                windowMap.put(character, 0);
            }

            windowMap.put(character, windowMap.get(character) + 1);

            if (windowMap.size() <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
                continue;
            }

            Character leftChar = s.charAt(left);

            windowMap.put(leftChar, windowMap.get(leftChar) - 1);

            if (windowMap.get(leftChar) == 0) {
                windowMap.remove(leftChar);
            }

            left++;
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct_slidingwindow("eceba", 2));
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct_slidingwindow("aa", 1));
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct_slidingwindow("aba", 1));
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct_slidingwindow("abee", 1));
    }
}