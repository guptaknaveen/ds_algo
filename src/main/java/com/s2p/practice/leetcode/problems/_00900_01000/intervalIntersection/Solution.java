package com.s2p.practice.leetcode.problems._00900_01000.intervalIntersection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 * 986. Interval List Intersections
 */
public class Solution {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0) {
            return new int[][]{};
        }
        List<List<Integer>> result = new ArrayList<>();
        int i = 0, j = 0, size1 = firstList.length, size2 = secondList.length;

        int start = Integer.MIN_VALUE, end = Integer.MAX_VALUE;

        int cord1[], cord2[];

        while (true) {
            if (i >= size1 || j >= size2) {
                break;
            }

            cord1 = firstList[i];
            cord2 = secondList[j];

            if (cord1[0] > cord2[1] ) {
                j++;
                continue;
            }

            if (cord1[1] < cord2[0]) {
                i++;
                continue;
            }

            start = max(start, cord1[0], cord2[0]);
            end = min(cord1[1], cord2[1]);

            result.add(Arrays.asList(start, end));

            if (end == cord1[1]) {
                i++;
            }

            if (end == cord2[1]) {
                j++;
            }

            start = end;
        }

        int[][] solution = new int[result.size()][2];

        for (i=0; i<result.size(); i++) {
            solution[i][0] = result.get(i).get(0);
            solution[i][1] = result.get(i).get(1);
        }

        return solution;
    }

    private int min(int a, int b) {
        return Math.min(a, b);
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        int[][] result = new Solution().intervalIntersection(new int[][]{{1,7}}, new int[][]{{3,10}});

        result = new Solution().intervalIntersection(new int[][]{}, new int[][]{{3,10}});

        result = new Solution().intervalIntersection(new int[][]{{1,7}}, new int[][]{});

        result = new Solution().intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}},
                new int[][]{{1,5},{8,12},{15,24},{25,26}});
    }
}
