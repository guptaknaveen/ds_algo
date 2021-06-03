package com.s2p.practice.leetcode.problems._00300_00400.nestedWeightSum;

import java.util.List;

/**
 * /problems/nested-list-weight-sum/
 * 339. Nested List Weight Sum
 */
public class Solution {
    private interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 0);
    }

    private int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger nestedInteger : nestedList) {
            sum+=depthSum(nestedInteger, depth + 1);
        }
        return sum;
    }

    private int depthSum(NestedInteger nestedInteger, int depth) {
        if (nestedInteger.isInteger()) {
            return depth * nestedInteger.getInteger();
        }
        return depthSum(nestedInteger.getList(), depth);
    }
}
