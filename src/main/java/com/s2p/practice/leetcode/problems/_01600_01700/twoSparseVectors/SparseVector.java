package com.s2p.practice.leetcode.problems._01600_01700.twoSparseVectors;

import com.s2p.practice.algorithm.lsc.Solution;

import java.util.*;

/**
 * https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
 * 1570. Dot Product of Two Sparse Vectors
 */
public class SparseVector {
    Map<Integer, Integer> mapping;

    SparseVector(int[] nums) {
        mapping = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                mapping.put(i, nums[i]);
            }
        }
    }

    public int dotProduct(SparseVector vec) {
        int result = 0;

        Integer value;

        for (Map.Entry<Integer, Integer> i : this.mapping.entrySet()) {

            value = vec.mapping.get(i.getKey());

            if (value == null) {
                continue;
            }


            result += i.getValue() * value;

        }
        return result;
    }

    public static void main(String[] args) {

    }
}
