package com.s2p.practice.leetcode.problems._00900_01000.checkCompletenessBT;

/**
 * /problems/check-completeness-of-a-binary-tree/
 * 958. Check Completeness of a Binary Tree
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

    public boolean isCompleteTree(TreeNode root) {
        return isCompleteTree(root, noOfElements(root), 0);
    }

    private boolean isCompleteTree(TreeNode node, int size, int calculatedIndex) {
        if (node == null) {
            return true;
        }

        int lIndex = 2*calculatedIndex + 1;
        int rIndex = 2*calculatedIndex + 2;

        if (calculatedIndex + 1 > size) {
            return false;
        }

        return isCompleteTree(node.left, size, lIndex)
                && isCompleteTree(node.right, size, rIndex);
    }
    
    private int noOfElements(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return noOfElements(node.left) + noOfElements(node.right) + 1;
    }
}
