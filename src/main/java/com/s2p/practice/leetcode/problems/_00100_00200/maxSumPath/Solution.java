package com.s2p.practice.leetcode.problems._00100_00200.maxSumPath;

/**
 *  124 : https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int MAX_SUM = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        updateMaxPathSum(root);
        return MAX_SUM;
    }

    private int updateMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = max(updateMaxPathSum(root.left), 0);
        int rightMax = max(updateMaxPathSum(root.right), 0);

        int self = root.val + leftMax + rightMax;

        if (self > MAX_SUM) {
            MAX_SUM  = self;
        }

        int result = root.val + max(leftMax, rightMax);

        if (result > MAX_SUM) {
            MAX_SUM = result;
        }

        return result;
    }

    private int max(int...a) {
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}