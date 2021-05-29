package com.s2p.practice.leetcode.problems._00700_00800.sortedCircularLL;

/**
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
 * 708. Insert into a Sorted Circular Linked List
 */
public class Solution {
    private class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node minNode, maxNode = head;

        Node curr = head;

        boolean startAgain = false;

        while (true) {
            if (startAgain) {
                break;
            }

            if (maxNode.val < curr.val) {
                maxNode = curr;
            }

            curr = curr.next;

            if (curr == head) {
                startAgain = true;
            }
        }

        minNode = maxNode.next;

        if (newNode.val <= minNode.val || newNode.val >= maxNode.val) {
            maxNode.next = newNode;
            newNode.next = minNode;

            return head;
        }

        boolean doInsert = false;

        Node prev = curr;
        while (true) {
            if (doInsert) {
                prev.next = newNode;
                newNode.next = curr;
                break;
            }
            prev = curr;
            curr = curr.next;

            if (prev.val <= newNode.val && curr.val >= newNode.val) {
                doInsert = true;
            }
        }

        return head;
    }


    /*


    public Node insert(Node head, int insertVal) {
    if (head == null) {
      Node newNode = new Node(insertVal, null);
      newNode.next = newNode;
      return newNode;
    }

    Node prev = head;
    Node curr = head.next;
    boolean toInsert = false;

    do {
      if (prev.val <= insertVal && insertVal <= curr.val) {
        // Case 1).
        toInsert = true;
      } else if (prev.val > curr.val) {
        // Case 2).
        if (insertVal >= prev.val || insertVal <= curr.val)
          toInsert = true;
      }

      if (toInsert) {
        prev.next = new Node(insertVal, curr);
        return head;
      }

      prev = curr;
      curr = curr.next;
    } while (prev != head);

    // Case 3).
    prev.next = new Node(insertVal, curr);
    return head;
  }



     */
}
