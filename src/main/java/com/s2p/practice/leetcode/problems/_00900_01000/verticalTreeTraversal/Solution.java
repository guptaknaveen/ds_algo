package com.s2p.practice.leetcode.problems._00900_01000.verticalTreeTraversal;

import java.util.*;

/**
 * /problems/vertical-order-traversal-of-a-binary-tree/
 * 987. Vertical Order Traversal of a Binary Tree
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

    private static class Triplet {
        int row, col, value;
        Triplet(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    private Map<Integer, List<Triplet>> TREE_COL_MAP = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        buildTreeColMap(root, 0, 0);

        for (List<Triplet> list : TREE_COL_MAP.values()) {
            Collections.sort(list, new Comparator<Triplet>() {
                @Override
                public int compare(Triplet o1, Triplet o2) {
                    if (o1.col == o2.col) {
                        if (o1.row == o2.row) {
                            return o1.value - o2.value;
                        }
                        return o1.row - o2.row;
                    }
                    return o1.col = o2.col;
                }
            });
        }

        List<List<Integer>> result = new ArrayList<>();

        for (List<Triplet> entry : TREE_COL_MAP.values()) {
            result.add(convertToIntegerList(entry));
        }

        return result;
    }

    private List<Integer> convertToIntegerList(List<Triplet> triplets) {
        List<Integer> valueList = new ArrayList<>();
        for (Triplet t : triplets) {
            valueList.add(t.value);
        }
        return valueList;
    }

    private void buildTreeColMap(TreeNode root, int col, int row) {
        if (root == null) {
            return;
        }
        List<Triplet> values = TREE_COL_MAP.get(col);

        if (values == null) {
            values = new ArrayList<>();
            TREE_COL_MAP.put(col, values);
        }

        values.add(new Triplet(row, col, root.val));

        buildTreeColMap(root.left, col-1, row + 1);
        buildTreeColMap(root.right, col+1, row + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(4, null, null),
                        new TreeNode(6, null, null)),
                new TreeNode(
                        3,
                        new TreeNode(5, null, null),
                        new TreeNode(7, null, null))
                );

        List<List<Integer>> result = new Solution().verticalTraversal(treeNode);

        System.out.println(result);
    }
}
