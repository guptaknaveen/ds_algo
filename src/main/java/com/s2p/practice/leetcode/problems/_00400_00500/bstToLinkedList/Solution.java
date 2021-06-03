package com.s2p.practice.leetcode.problems._00400_00500.bstToLinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * /problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 * 426. Convert Binary Search Tree to Sorted Doubly Linked List
 */
public class Solution {
    private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private List<Integer> inorder = new ArrayList<>();

//    public Node treeToDoublyList(Node root) {
    public Node treeToDoublyList_01(Node root) {
        inorderTraversal(root);
        return createDLLFromInorder(inorder);
    }

    public Node treeToDoublyList(Node root) {
//    public Node treeToDoublyList_02(Node root) {
        return createDLLFromInorder_2(root)[0];
    }

    private void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
    }

    private Node createDLLFromInorder(List<Integer> inorder) {
        if (inorder == null || inorder.size() == 0) {
            return null;
        }
        int size = inorder.size();
        Node start = new Node(inorder.get(0));
        if (size == 1) {
            return start;
        }
        Node prev = start, curr = start;

        int i = 1;

        while (true) {
            if (i >= size) {
                break;
            }
            curr = new Node(inorder.get(i));
            curr.left = prev;
            prev.right = curr;

            prev = curr;
            i++;
        }

        start.left = curr;
        curr.right = start;

        return start;
    }

    private Node[] createDLLFromInorder_2(Node root) {
        if (root == null) {
            return null;
        }
        Node start = null, end = null;

        if (root.left == null && root.right == null) {
            start = root;
            end = root;
            start.right = end;
            end.left = start;
            return new Node[]{start, end};
        }

        Node[] leftDLL = createDLLFromInorder_2(root.left);

        Node rootRight = root.right;

        if (leftDLL != null) {

            start = leftDLL[0];
            end = leftDLL[1];

            start.left = root;
            root.right = start;

            end.right = root;
            root.left = end;

            end = root;

        }

        Node[] rightDLL = createDLLFromInorder_2(rootRight);

        if (rightDLL != null) {

            if (start == null) {
                start = root;
            }

            if (end == null) {
                end = root;
            }

            start.left = rightDLL[1];
            rightDLL[1].right = start;

            end.right = rightDLL[0];
            rightDLL[0].left = end;

            end = rightDLL[1];
        }

        return new Node[]{start, end};
    }
}
