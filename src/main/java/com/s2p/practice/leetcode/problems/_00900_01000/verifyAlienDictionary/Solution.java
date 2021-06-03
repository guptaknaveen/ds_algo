package com.s2p.practice.leetcode.problems._00900_01000.verifyAlienDictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * /problems/verifying-an-alien-dictionary/
 * 953. Verifying an Alien Dictionary
 */
public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int size = words.length;
        if (size == 1) {
            return true;
        }

        Map<Character, Integer> orderMap = new HashMap();

        int i = 0;
        for (char ch : order.toCharArray()) {
            orderMap.put(ch, i++);
        }

        boolean compare;
        for (i=0; i<size-1; i++) {
            compare = compare(words[i], words[i+1], orderMap);
            if (compare) {
                continue;
            }
            return false;
        }

        return true;

    }

    private boolean compare(String first, String second, Map<Character, Integer> orderMap) {
        int i = 0;
        while (true) {
            if (i >= first.length() || i >= second.length()) {
                break;
            }

            if (orderMap.get(first.charAt(i)) > orderMap.get(second.charAt(i))) {
                return false;
            } else if (orderMap.get(first.charAt(i)) < orderMap.get(second.charAt(i))) {
                return true;
            }
            i++;
        }

        if (first.length() > second.length()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(new Solution().isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(new Solution().isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
