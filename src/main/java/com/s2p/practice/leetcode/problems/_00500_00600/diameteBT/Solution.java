package com.s2p.practice.leetcode.problems._00500_00600.diameteBT;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * 543. Diameter of Binary Tree
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

    private int RESULT = Integer.MIN_VALUE;

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = 1 + height(node.left);
        int rightHeight = 1 + height(node.right);

        if (leftHeight + rightHeight > RESULT) {
            RESULT = leftHeight + rightHeight;
        }

        return Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return RESULT - 2;
    }
}
