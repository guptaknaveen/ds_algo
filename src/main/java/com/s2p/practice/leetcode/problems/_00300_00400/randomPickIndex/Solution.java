package com.s2p.practice.leetcode.problems._00300_00400.randomPickIndex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * /problems/random-pick-index/
 * 398. Random Pick Index
 */
public class Solution {
    Map<Integer, List<Integer>> indexMap = new HashMap<>();

    public Solution(int[] nums) {

        List<Integer> indexes;
        int i = 0;
        for (int n : nums) {
            indexes = this.indexMap.get(n);

            if (indexes == null) {
                indexes = new ArrayList<>();
            }
            indexes.add(i);
            indexMap.put(n, indexes);
            i++;
        }

    }

    public int pick(int target) {
        int randIndex = -1;

        List<Integer> indexes = this.indexMap.get(target);

        if (indexes == null) {
            return randIndex;
        }

        randIndex = (int) (Math.random() * indexes.size());

        return indexes.get(randIndex);
    }
}
