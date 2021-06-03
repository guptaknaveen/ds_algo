package com.s2p.practice.leetcode.problems._00200_00300.lowestCommonAncestor;

/**
 * /problems/lowest-common-ancestor-of-a-binary-tree/
 * 236. Lowest Common Ancestor of a Binary Tree
 */
public class Solution {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p) {
            return p;
        }
        if (root == q) {
            return q;
        }
        TreeNode leftFound = lowestCommonAncestor(root.left, p, q);
        TreeNode rightFound = lowestCommonAncestor(root.right, p, q);

        if ((leftFound == p && rightFound == q) || (leftFound == q && rightFound == q)) {
            return root;
        }

        return null;
    }


    public static void main(String[] args) {

    }
}
