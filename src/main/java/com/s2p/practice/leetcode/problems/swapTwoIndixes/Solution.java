package com.s2p.practice.leetcode.problems.swapTwoIndixes;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean buddyStrings(String a, String b) {
        if (a==null || b==null) {
            return false;
        }
        if (a.length() <= 0 || b.length()<=0) {
            return false;
        }

        if (a.length() != b.length()) {
            return false;
        }

        if (a.equals(b)) {
            return true;
        }

        Map<Character, Integer> aMap = new HashMap();
        Map<Character, Integer> bMap = new HashMap();

        StringBuilder ta = new StringBuilder();
        StringBuilder tb = new StringBuilder();

        boolean hasRepeatCharacters = false;

        for (int i = 0;i<a.length(); i++) {

            if (aMap.get(a.charAt(i))==null) {
                aMap.put(a.charAt(i), 0);
            }
            aMap.put(a.charAt(i), aMap.get(a.charAt(i)) + 1);

            if (bMap.get(b.charAt(i))==null) {
                bMap.put(b.charAt(i), 0);
            }
            bMap.put(b.charAt(i), bMap.get(b.charAt(i)) + 1);

            if (aMap.get(a.charAt(i)) > 1 && aMap.get(a.charAt(i)) == bMap.get(b.charAt(i))) {
                hasRepeatCharacters = true;
            }

            if (a.charAt(i) == b.charAt(i)) {
                continue;
            }

            ta.append(a.charAt(i));
            tb.append(b.charAt(i));
        }

        return ( ta.length() == 0 &&  hasRepeatCharacters ) || ( ta.length() == 2 && ta.length() == tb.length() && ta.charAt(0) == tb.charAt(1) && ta.charAt(1) == tb.charAt(0));

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.buddyStrings("abcaa", "abcbb"));
    }
}