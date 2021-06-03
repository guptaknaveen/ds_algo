package com.s2p.practice.leetcode.problems._00800_00900.allNodeKDistBT;

import java.util.*;

/**
 * /problems/all-nodes-distance-k-in-binary-tree/
 * 863. All Nodes Distance K in Binary Tree
 */
public class Solution {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<TreeNode, TreeNode> parent;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        this.parent = new HashMap();
        dfs(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        queue.add(null);

        TreeNode parent, currentNode;

        Set<TreeNode> seen = new HashSet<>();

        int d = 0;

        while (true) {
            if (d == K  || queue.isEmpty()) {
                break;
            }
            currentNode = queue.poll();

            if (currentNode == null) {
                queue.add(null);
                d++;
            } else {
                if (seen.contains(currentNode)) {
                    continue;
                } else {
                    seen.add(currentNode);

                    if (currentNode.left != null && !seen.contains(currentNode.left)) {
                        queue.add(currentNode.left);
                    }
                    if (currentNode.right != null && !seen.contains(currentNode.right)) {
                        queue.add(currentNode.right);
                    }
                    parent = this.parent.get(currentNode);
                    if (parent != null && !seen.contains(parent)) {
                        queue.add(parent);
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while (true) {
            currentNode = queue.poll();
            if (currentNode == null) {
                break;
            }
            result.add(currentNode.val);
        }

        return result;
    }

    public void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            parent.put(node, par);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }

    public static void main(String[] args) {
        TreeNode targetNode = new TreeNode(
                5,
                new TreeNode(
                        6, null, null
                ),
                new TreeNode(
                        2,
                        new TreeNode(
                                7, null, null
                        ),
                        new TreeNode(
                                4, null, null
                        )
                )
        );

        TreeNode treeNode = new TreeNode(
                3,
                targetNode,
                new TreeNode(
                        1,
                        new TreeNode(
                                0, null, null
                        ),
                        new TreeNode(
                                8, null, null
                        )
                )
        );

        List<Integer> result = new Solution().distanceK(treeNode, targetNode, 2);
        System.out.println(result);
    }
}
