package com.s2p.practice.leetcode.problems._00200_00300.serialDeserialBT;

import com.s2p.practice.leetcode.problems._00900_01000.verticalTreeTraversal.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 297. Serialize and Deserialize Binary Tree
 */
// TODO : Need to complete
public class Codec {
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

    private List<Integer> TREE_VALUES = new ArrayList<>();
    private StringBuilder TREE_STR = new StringBuilder();
    private TreeNode TREE = new TreeNode();

    public String serialize(TreeNode root) {
        traverse(root);
        return TREE_STR.toString();
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            TREE_VALUES.add(null);
            return;
        }
        TREE_VALUES.add(root.val);

        if (root.left != null) {
            TREE_VALUES.add(root.left.val);
        }
        if (root.right != null) {
            TREE_VALUES.add(root.right.val);
        }
        traverse(root.left);
        traverse(root.right);
    }

    public TreeNode deserialize(String data) {
return null;
    }
}
