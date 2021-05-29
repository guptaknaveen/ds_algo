package com.s2p.practice.leetcode.problems._00900_01000.kClosestPoint;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * 973. K Closest Points to Origin
 */
public class Solution {
    private class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int squareDistanceFromOrigin() {
            return x*x + y*y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Coordinate> result = new PriorityQueue<>(new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                return o2.squareDistanceFromOrigin() - o1.squareDistanceFromOrigin();
            }
        });

        Coordinate curr, fromQueue;
        for (int[] point : points) {
            curr = new Coordinate(point[0], point[1]);
            if (result.size() < k) {
                result.offer(curr);
                continue;
            }
            fromQueue = result.peek();
            if (fromQueue.squareDistanceFromOrigin() < curr.squareDistanceFromOrigin()) {
                continue;
            }
            result.poll();
            result.add(curr);
        }

        int[][] solution = new int[k][2];
        int i = 0;
        while (true) {
            if (result.isEmpty()) {
                break;
            }
            curr = result.poll();
            solution[i][0] = curr.x;
            solution[i][1] = curr.y;

            i++;
        }

        return solution;
    }

    public static void main(String[] args) {
        int result[][] = new Solution().kClosest(new int[][]{{1,3},{-2,2}}, 1);
        result = new Solution().kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2);
        System.out.println(result);
    }
}
