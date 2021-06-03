package com.s2p.practice.leetcode.problems._00900_01000.rangeBST;

/**
 * /problems/range-sum-of-bst/
 * 938. Range Sum of BST
 */
public class Solution {
    private static class TreeNode {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    
    public int rangeSumBST(TreeNode root, int low, int high) {

        if(root == null) {
            return 0;
        }

        int sum = 0;
        if (root.val >= low && root.val <= high) {
            sum = root.val;
        }

        return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) + sum;
    }
}
