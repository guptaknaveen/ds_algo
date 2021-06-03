package com.s2p.practice.leetcode.problems._00200_00300.serialDeserialBT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * /problems/serialize-and-deserialize-binary-tree/
 * 297. Serialize and Deserialize Binary Tree
 * leetcode solution
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

    public String serialize_02(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        TREE_VALUES.add(root.val);
        traverse(root);
        TREE_STR.append("[");
        for (Integer i : TREE_VALUES) {
            if (i == null) {
                TREE_STR.append("null,");
                continue;
            }
            TREE_STR.append(i).append(",");
        }
        TREE_STR.setCharAt(TREE_STR.length() - 1,']');
        return TREE_STR.toString();
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            TREE_VALUES.add(root.left.val);
        } else {
            TREE_VALUES.add(null);
        }
        if (root.right != null) {
            TREE_VALUES.add(root.right.val);
        } else {
            TREE_VALUES.add(null);
        }
        traverse(root.left);
        traverse(root.right);
    }

    public String rserialize(TreeNode root, String str) {
        // Recursive serialization.
        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode rdeserialize(List<String> l) {
        // Recursive deserialization.
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
        return rdeserialize(data_list);
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
        System.out.println(new Codec().serialize(treeNode));
    }
}
