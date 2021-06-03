package com.s2p.practice.leetcode.problems._00000_00100.mergeInterval;

import java.util.*;

/*
    56 : /problems/merge-intervals/
 */
public class Solution {
    private class Interval {
        int a, b;

        public Interval(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 1) {
            return intervals;
        }

        List<Interval> intervalList = new ArrayList<>();

        for (int a[] : intervals) {
            intervalList.add(new Interval(a[0], a[1]));
        }

        Collections.sort(intervalList, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.a == o2.a) {
                    return o1.b - o2.b;
                }
                return o1.a - o2.a;
            }
        });

        int i = 0;
        Interval tempInterval = intervalList.get(i);

        List<Interval> tempIntervalList = null;

        List<Interval> resultList = new ArrayList<>();

        for (i = 1; i<intervalList.size(); i++) {
            tempIntervalList = mergeInterval(tempInterval, intervalList.get(i));
            if (tempIntervalList.size() == 1) {
                tempInterval = tempIntervalList.get(0);
                continue;
            }
            resultList.add(tempIntervalList.get(0));
            tempInterval = tempIntervalList.get(1);
        }

        resultList.add(tempInterval);

        int result[][] = new int[resultList.size()][2];

        i = 0;
        for (Interval interval : resultList) {
            result[i][0] = interval.a;
            result[i][1] = interval.b;
            i++;
        }

        return result;
    }

    private List<Interval> mergeInterval(Interval first, Interval second) {
        if (first.b < second.a) {
            return Arrays.asList(first, second);
        }
        if (first.b >= second.b) {
            return Arrays.asList(first);
        }
        return Arrays.asList(new Interval(first.a, second.b));
    }

    public static void main(String[] args) {
        //[[1,3],[2,6],[8,10],[15,18]]
//        System.out.println(new Solution().merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
//        System.out.println(new Solution().merge(new int[][]{{1,4},{4,5}}));
        System.out.println(new Solution().merge(new int[][]{{1,4},{0,4}}));
    }
}
