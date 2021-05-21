package com.s2p.practice.leetcode.problems._00700_00800.charCustomSort;

import java.util.*;

/**
 * 791 : https://leetcode.com/problems/custom-sort-string/
 */
public class Solution {
    public String customSortString(String order, String str) {
        List<Character> characters = new ArrayList<>();

        final Map<Character, Integer> charValue = new HashMap<>();

        for (int i = 0;i<str.length(); i++) {
            characters.add(str.charAt(i));
        }

        for (int i = 0;i<order.length(); i++) {
            charValue.put(order.charAt(i), i);
        }

        Collections.sort(characters, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {

                Integer o1Value = charValue.get(o1);
                Integer o2Value = charValue.get(o2);

                if (o1Value == null) {
                    o1Value = Integer.MAX_VALUE;
                }

                if (o2Value == null) {
                    o2Value = Integer.MAX_VALUE;
                }

                return o1Value - o2Value;
            }
        });

        StringBuilder result = new StringBuilder();

        for (Character ch : characters) {
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.customSortString("exv", "xwvee"));
    }
}