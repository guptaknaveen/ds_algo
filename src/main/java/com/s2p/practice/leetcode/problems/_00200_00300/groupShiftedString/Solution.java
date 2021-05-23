package com.s2p.practice.leetcode.problems._00200_00300.groupShiftedString;

import java.util.*;

/**
 * https://leetcode.com/problems/group-shifted-strings/
 * 249. Group Shifted Strings
 */
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        int size = strings.length;
        List<List<String>> result = new ArrayList<>();

        if (size == 1) {
            result.add(Arrays.asList(strings[0]));
            return result;
        }

        result = new ArrayList<>(createDiffMap(strings).values());

        return result;
    }

    private Map<String, List<String>> createDiffMap(String[] strings) {
        Map<String, List<String>> diffMap = new HashMap<>();

        List<String> tempDiffList;
        String tempDiffStr;

        for (String s : strings) {
            tempDiffStr = fetchDiffString(s);
            tempDiffList = diffMap.get(tempDiffStr);
            if (tempDiffList == null) {
                tempDiffList = new ArrayList<>();
                diffMap.put(tempDiffStr, tempDiffList);
            }
            tempDiffList.add(s);
        }

        return diffMap;
    }

    private String fetchDiffString(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        if(s.length() == 1) {
            return "[SINGLE_CHARACTER]";
        }

        int size = s.length();
        int i =1;
        int diffInt;

        StringBuilder diff = new StringBuilder();

        while (true) {
            if (i == size) {
                break;
            }
            diffInt = (s.charAt(i) - s.charAt(i - 1) + 26)%26;

            if (diffInt < 10) {
                diff.append("0").append(diffInt);
            } else {
                diff.append(diffInt);
            }

            i++;
        }

        return diff.toString();
    }

    public static void main(String[] args) {
        List<List<String>> result = new Solution().groupStrings(
                new String[]{"abc","bcd","acef","xyz","az","ba","a","z"}
        );
        System.out.println(result.size());

        result = new Solution().groupStrings(
                new String[]{"a"}
        );
        System.out.println(result.size());
    }
}
