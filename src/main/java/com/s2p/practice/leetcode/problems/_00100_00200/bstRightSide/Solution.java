package com.s2p.practice.leetcode.problems._00100_00200.bstRightSide;

import java.util.*;

/**
 *  199 : /problems/binary-tree-right-side-view/
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
    }

    private Map<Integer, Integer> LEVEL_MAP = new TreeMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        buildLevelMap(root, 1);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> i : LEVEL_MAP.entrySet()) {
            result.add(i.getValue());
        }
        return result;
    }

    public List<Integer> rightSideViewWithQueue(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        int prev = root.val;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        TreeNode curr;

        while (true) {
            if (queue.isEmpty()) {
                break;
            }

            curr = queue.poll();

            if (curr == null) {
                result.add(prev);
                queue.add(null);
                continue;
            }

            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }

            prev = curr.val;
        }

        return result;
    }

    private void buildLevelMap(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        LEVEL_MAP.put(level, node.val);
        buildLevelMap(node.left, level + 1);
        buildLevelMap(node.right, level + 1);
    }
}
