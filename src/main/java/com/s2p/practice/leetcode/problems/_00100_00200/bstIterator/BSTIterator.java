package com.s2p.practice.leetcode.problems._00100_00200.bstIterator;

import java.util.LinkedList;

/**
 *  173 : https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BSTIterator {

    private class TreeNode {
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


    private LinkedList<TreeNode> linkedList = new LinkedList();

    public BSTIterator(TreeNode root) {
        createINOTLL(root);
    }

    private TreeNode createINOTLL(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = createINOTLL(root.left);

        if (left != null) {
            linkedList.add(left);
        }

        linkedList.add(root);

        TreeNode right = createINOTLL(root.right);

        if (right != null) {
            linkedList.add(right);
        }

        return null;
    }

    public int next() {
        return linkedList.poll().val;
    }

    public boolean hasNext() {
        return !linkedList.isEmpty();
    }
}
