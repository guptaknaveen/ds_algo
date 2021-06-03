package com.s2p.practice.leetcode.problems._01600_01700.lowestCommonAncestorIII;

import java.util.*;

/**
 * /problems/lowest-common-ancestor-of-a-binary-tree-iii/
 * 1650. Lowest Common Ancestor of a Binary Tree III
 */
public class Solution {
    private class Node {
        int val;
        Node left;
        Node right;
        Node parent;
    }

    private Node result;

    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Integer> parents = new HashSet();

        setParentNodes(p, parents);

        setParentNodes(q, parents);

        return result;
    }

    private void setParentNodes(Node node, Set<Integer> possibleParents) {
        if (node == null) {
            return;
        }

        if (possibleParents.contains(node.val) && this.result == null) {
            this.result = node;
            return;
        }

        possibleParents.add(node.val);
        setParentNodes(node.parent, possibleParents);
    }

    private boolean lowestCommonAncestor01(Node root, Node p, Node q){
        if (root == null) {
            return false;
        }

        boolean leftFound = lowestCommonAncestor01(root.left, p, q);
        boolean rightFound = lowestCommonAncestor01(root.right, p, q);
        boolean currentFound = root == p || root == q;

        if ((leftFound && rightFound) || (leftFound && currentFound) ||(currentFound && rightFound)) {
            this.result = root;
        }

        return leftFound || rightFound || currentFound;
    }
}