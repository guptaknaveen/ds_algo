package com.s2p.practice.leetcode.problems._01200_01300.validPallindromeII;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * /problems/valid-palindrome-iii/
 * 1216. Valid Palindrome III
 */
public class Solution {
    private class CacheEntry {
        int start;
        int end;

        public CacheEntry(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CacheEntry that = (CacheEntry) o;
            return start == that.start &&
                    end == that.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    public boolean isValidPalindrome(String s, int k) {
        int result = removeCharactersToPalindrome(s, 0, s.length() - 1);
        return result <= k;
    }

    private Map<CacheEntry, Integer> CACHE = new HashMap<>();

    private Integer fromCache(int start, int end) {
        return CACHE.get(new CacheEntry(start, end));
    }

    private void putInCache(int start, int end, int k) {
        CACHE.put(new CacheEntry(start, end), k);
    }

    private int removeCharactersToPalindrome(String s, int start, int end) {
        Integer result;

        result = fromCache(start, end);

        if (result != null) {
            return result;
        }

        if (start == end) {
            result = 0;
        }

        else if (end == start + 1) {
            result = s.charAt(start) == s.charAt(end) ? 0 : 1;
        }

        else if (s.charAt(start) == s.charAt(end)) {
            result = removeCharactersToPalindrome(s, start + 1, end - 1);
        }

        else {
            result = Math.min(
                    removeCharactersToPalindrome(s, start + 1, end) + 1,
                    removeCharactersToPalindrome(s, start, end - 1) + 1
            );
        }
        putInCache(start, end, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValidPalindrome("fcgihcgeadfehgiabegbiahbeadbiafgcfchbcacedbificicihibaeehbffeidiaiighceegbfdggggcfaiibefbgeegbcgeadcfdfegfghebcfceiabiagehhibiheddbcgdebdcfegaiahibcfhheggbheebfdahgcfcahafecfehgcgdabbghddeadecidicchfgicbdbecibddfcgbiadiffcifiggigdeedbiiihfgehhdegcaffaggiidiifgfigfiaiicadceefbhicfhbcachacaeiefdcchegfbifhaeafdehicfgbecahidgdagigbhiffhcccdhfdbd", 216));
        System.out.println(new Solution().isValidPalindrome("abbababa", 1));
        System.out.println(new Solution().isValidPalindrome("abbababa", 2));
        System.out.println(new Solution().isValidPalindrome("abcdeca", 1));
        System.out.println(new Solution().isValidPalindrome("abbababa", 3));
    }
}
