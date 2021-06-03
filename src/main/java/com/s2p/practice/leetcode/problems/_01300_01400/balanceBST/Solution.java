package com.s2p.practice.leetcode.problems._01300_01400.balanceBST;

import java.util.ArrayList;
import java.util.List;

/**
 * /problems/balance-a-binary-search-tree/
 * 1382. Balance a Binary Search Tree
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

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderTreeTraversal(root, inOrder);
        return treeFromInorder(inOrder, 0, inOrder.size() - 1);
    }

    private void inOrderTreeTraversal(TreeNode root, List<Integer> inOrder) {
        if (root == null) {
            return;
        }
        inOrderTreeTraversal(root.left, inOrder);
        inOrder.add(root.val);
        inOrderTreeTraversal(root.right, inOrder);
    }

    private TreeNode treeFromInorder(List<Integer> inrOrder, int start, int end) {
        if (start < 0 || end >= inrOrder.size() || start > end) {
            return null;
        }
        TreeNode result;
        if (start == end) {
            result = new TreeNode(inrOrder.get(start), null, null);
            return result;
        }
        int rootIndex = (start + end) / 2;

        int leftStartIndex = start;
        int leftEndIndex = rootIndex - 1;

        int rightStartIndex = rootIndex + 1;
        int rightEndIndex = end;

        result = new TreeNode(
                inrOrder.get(rootIndex),
                treeFromInorder(inrOrder, leftStartIndex, leftEndIndex),
                treeFromInorder(inrOrder, rightStartIndex, rightEndIndex)
                );

        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                4,
                new TreeNode(
                        3,
                        new TreeNode(
                                2,
                                new TreeNode(1),
                                null),
                        null
                ),
                null
        );

        TreeNode result = new Solution().balanceBST(treeNode);

        System.out.println(result);
    }
}
